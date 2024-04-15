var token = localStorage.getItem("token");
async function loadAllSchedule() {
    $('#example').DataTable().destroy();
    var start = document.getElementById("start").value
    var end = document.getElementById("end").value
    var paid = document.querySelector('input[name="paid"]:checked').value;
    var schedule = {
        "startDate":start,
        "endDate":end,
        "paid":paid
    }
    if(start == "" || end == ""){
        start = null; end = null;
    }
    var url = 'http://localhost:8080/api/admin/allscheduleadmin'
    const response = await fetch(url, {
        method: 'POST',
        headers: new Headers({
            'Authorization': 'Bearer '+token,
            'Content-Type': 'application/json'
        }),
        body:JSON.stringify(schedule)
    });
    var listresult = await response.json(); 
    var main = '';
    for(i=0; i< listresult.length; i++){
        var disDel = '<button onclick="deleteSchedule('+listresult[i].id+')" class="btn btn-danger btn_nb"><i class="fa fa-trash"></i> delete schedule</button>'
        var disPay = '<button onclick="setId('+listresult[i].id+')" class="btn btn-success btn_nb" data-toggle="modal" data-target=".bd-example-modal-lg"><i class="fa fa-money"></i> pay</button>'
        if(listresult[i].paid == 1){
            disDel = '<button onclick="deleteInvoice('+listresult[i].id+')" class="btn btn-danger btn_nb"><i class="fa fa-trash"></i> delete invoice</button>'
            disPay = '<button onclick="loadDetailInvoice('+listresult[i].id+')" class="btn btn-success btn_nb" data-toggle="modal" data-target=".viewInvoice"><i class="fa fa-list"></i> View</button>'
        }
        main += '<tr>'+
                    '<td>'+disPay+'</td>'+
                    '<td>'+disDel+'</td>'+
                    '<td>#'+listresult[i].id+'</td>'+
                    '<td>'+listresult[i].bookingDate+'</td>'+
                    '<td>'+listresult[i].bookingTime+'</td>'+
                    '<td>'+listresult[i].patientRecord.fulllName+'</td>'+
                    '<td>'+listresult[i].patientRecord.phone+'</td>'+
                    '<td>'+listresult[i].patientRecord.specialist.name+'</td>'+
                    '<td>'+listresult[i].doctors.fulllName+'</td>'+
                    '<td><a href="tel:'+listresult[i].patientRecord.phone+'" class="btn btn-success btn_table"><i class="fa fa-phone"></i> call</a></td>'+
                    '<td><a href="mailto:'+listresult[i].patientRecord.user.email+'" target="_blank" class="btn btn-success btn_table"><i class="fa fa-envelope"></i> send</a></td>'+
                '</tr>'
    }
    document.getElementById("listschedule").innerHTML = main
    // $('#example').DataTable();
    $('#example').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'copyHtml5',
            'excelHtml5',
            'csvHtml5',
            'pdfHtml5'
        ]
    } );
}

function setId(id){
    document.getElementById("idschedule").value = id
}

async function loadAllProcessSchedule() {
    var url = 'http://localhost:8080/api/public/allMedicalProcess'
    const response = await fetch(url, {
        method: 'GET',
        headers: new Headers({
        })
    });
    var listresult = await response.json(); 
    var main = '';
    for(i=0; i< listresult.length; i++){
        main += '<option value="'+listresult[i].id+'" data-tokens="'+listresult[i].id+'">'+listresult[i].processName+'- '+listresult[i].price+'</option>'
    }
    document.getElementById("listprocess").innerHTML = main
    document.getElementById("listprocess").classList.add("selectpicker");
    $('.selectpicker').selectpicker();
}

var total = Number(0);
function previewOrder(){
    var listprice = [];
    var options = document.getElementById("listprocess").options;
    var opt;
    for (var i=0, iLen=options.length; i<iLen; i++) {
        opt = options[i];
        if (opt.selected) {
            listprice.push(opt.text.split("-")[1]);
        }
    }
    total = 0;
    for(i=0; i<listprice.length; i++){
        total += Number(listprice[i])
    }
    document.getElementById("totalmoney").innerText = total
    document.getElementById("addcost").innerText = Number(document.getElementById("valcost").value)
    document.getElementById("notetext").innerText = document.getElementById("notevalue").value
}

async function createInvoice(){
    var idschedule = document.getElementById("idschedule").value
    var totalAmount = total
    var note = document.getElementById("notevalue").value
    var cost = document.getElementById("valcost").value
    var listprocess = $('#listprocess').val();
    var invoice = {
        "totalAmount":Number(totalAmount)+Number(cost),
        "note":note,
        "schedule":{
            "id":idschedule
        },
        "listProcess":listprocess
    }
    console.log(invoice)
    console.log(totalAmount)
    console.log(cost)
    var url = 'http://localhost:8080/api/admin/addinvoice';
    const response = await fetch(url, {
        method: 'POST',
        headers: new Headers({
            'Authorization': 'Bearer '+token, 
            'Content-Type': 'application/json'
         }),
        body:JSON.stringify(invoice)
    });
    if(response.status < 300){
        swal({
            title: "Notification", 
            text: "create invoice successful!", 
            type: "success"
          },
        function(){ 
            window.location.reload();
        });
    }
    else{
        swal({
            title: "Notification", 
            text: "create invoice error!", 
            type: "error"
          },
        function(){ 
        });
    }
}

async function loadDetailInvoice(id) {
    $('#details').DataTable().destroy()
    var url = 'http://localhost:8080/api/admin/detailInvoiceByInvoiceId?id='+id
    const response = await fetch(url, {
        method: 'GET',
        headers: new Headers({
            'Authorization': 'Bearer '+token
        })
    });
    var listresult = await response.json(); 
    var main = '';
    for(i=0; i< listresult.length; i++){
        main += '<tr>'+
                    '<td>#'+listresult[i].id+'</td>'+
                    '<td>'+listresult[i].medicalProcess.processName+'</td>'+
                    '<td>'+listresult[i].medicalProcess.price+'</td>'+
                    '<td><button onclick="deleteDetail('+listresult[i].id+')" class="btn btn-danger btn_nb"><i class="fa fa-trash"></i> delete</button></td>'+
                '</tr>'
    }
    main += '<tr>'+
                '<td>total</td>'+
                '<td></td>'+
                '<td style="font-size: 20px; font-weight: bold;">'+listresult[0].invoice.totalAmount+'</td>'+
                '<td></td>'+
            '</tr>'
    document.getElementById("listdetail").innerHTML = main

    // $('#details').DataTable();
    $('#details').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'copyHtml5',
            'excelHtml5',
            'csvHtml5',
            'pdfHtml5'
        ]
    } );
}


async function deleteDetail(id) {
    var url = 'http://localhost:8080/api/admin/deleteDetailInvoice?id='+id
    const response = await fetch(url, {
        method: 'DELETE',
        headers: new Headers({
            'Authorization': 'Bearer '+token
        })
    });
    if(response.status < 300){
        swal({
            title: "Notification", 
            text: "delete successful!", 
            type: "success"
            },
        function(){ 
            window.location.reload();
        });
    }
    else{
        swal({
            title: "Notification", 
            text: "can't delete this detail!", 
            type: "error"
            },
        function(){ 
        });
    }
}

async function deleteSchedule(id) {
    var url = 'http://localhost:8080/api/admin/deleteScheduleByAdmin?id='+id
    const response = await fetch(url, {
        method: 'DELETE',
        headers: new Headers({
            'Authorization': 'Bearer '+token
        })
    });
    if(response.status < 300){
        swal({
            title: "Notification", 
            text: "delete successful!", 
            type: "success"
            },
        function(){ 
            window.location.reload();
        });
    }
    else{
        swal({
            title: "Notification", 
            text: "can't delete this schedule!", 
            type: "error"
            },
        function(){ 
        });
    }
}

async function deleteInvoice(id) {
    var url = 'http://localhost:8080/api/admin/deleteInvoice?id='+id
    const response = await fetch(url, {
        method: 'DELETE',
        headers: new Headers({
            'Authorization': 'Bearer '+token
        })
    });
    if(response.status < 300){
        swal({
            title: "Notification", 
            text: "delete successful!", 
            type: "success"
            },
        function(){ 
            window.location.reload();
        });
    }
    else{
        swal({
            title: "Notification", 
            text: "can't delete this invoice!", 
            type: "error"
            },
        function(){ 
        });
    }
}

async function addProcessToInvoice() {
    var idschedule = document.getElementById("idscheduledetail").value
    var listprocess = $('#listprocessDetail').val();
    var process = {
        "scheduleId":idschedule,
        "listProcess":listprocess
    }
    var url = 'http://localhost:8080/api/admin/addProcessToDetail'
    const response = await fetch(url, {
        method: 'POST',
        headers: new Headers({
            'Authorization': 'Bearer '+token, 
            'Content-Type': 'application/json'
         }),
        body:JSON.stringify(process)
    });
    if(response.status < 300){
        swal({
            title: "Notification", 
            text: "add process successful!", 
            type: "success"
            },
        function(){ 
            window.location.reload();
        });
    }
    else{
        swal({
            title: "Notification", 
            text: "can't add process!", 
            type: "error"
            },
        function(){ 
        });
    }
}