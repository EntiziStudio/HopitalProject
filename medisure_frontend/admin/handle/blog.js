var token = localStorage.getItem("token");
async function loadAllBlog() {
    var url = 'http://localhost:8080/api/public/allBlog'
    const response = await fetch(url, {
        method: 'GET',
        headers: new Headers({
        })
    });
    var listresult = await response.json(); 
    var main = '';
    for(i=0; i< listresult.length; i++){
        main += '<tr>'+
                    '<td>#'+listresult[i].id+'</td>'+
                    '<td><img class="imgblogadmin" src="'+listresult[i].imageBanner+'"></td>'+
                    '<td>'+listresult[i].title+'</td>'+
                    '<td>'+listresult[i].createdDate+'</td>'+
                    '<td><button onclick="deleteBlog('+listresult[i].id+')" class="btn btn-danger"><i class="fa fa-trash"></i> delete</button></td>'+
                    '<td><button onclick="replace('+listresult[i].id+')" class="btn btn-primary"><i class="fa fa-edit"></i> update</button></td>'+
                '</tr>'
    }
    document.getElementById("listspecialist").innerHTML = main
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
function replace(id){
    window.location.replace('addblog.html?id='+id)
}

async function loadAblog() {
    var id = window.location.search.split('=')[1];
    if(id != null){
        var url = 'http://localhost:8080/api/public/getBlogById?id='+id;
        const response = await fetch(url, {
            method: 'GET',
            headers: new Headers({
            })
        });
        var blog = await response.json();
        document.getElementById("idblog").value = blog.id
        document.getElementById("title").value = blog.title
        document.getElementById("description").value = blog.description
        document.getElementById("avatar_img").src = blog.imageBanner
        imagebanners = blog.imageBanner
        tinyMCE.get('editor').setContent(blog.content)
    }
}

var imagebanners = ''
async function addBlog(){
    const filePath = document.getElementById('imagebanner')
    const formData = new FormData()
    formData.append("file", filePath.files[0])
    var urlUpload = 'http://localhost:8080/api/public/upload';
    const res = await fetch(urlUpload, { 
             method: 'POST', 
              headers: new Headers({
             }),
             body: formData
    });
    if(res.status < 300){
        imagebanners = await res.text();
    }

    var token = localStorage.getItem("token");
    var id = document.getElementById("idblog").value
    var title = document.getElementById("title").value
    var description = document.getElementById("description").value
    var content = tinyMCE.get('editor').getContent()
    var blog = {
        "id":id,
        "title":title,
        "description":description,
        "content":content,
        "imageBanner":imagebanners
    }
    var url = 'http://localhost:8080/api/admin/saveOrUpdateBlog';
    const response = await fetch(url, {
        method: 'POST',
        headers: new Headers({
            'Authorization': 'Bearer '+token, 
            'Content-Type': 'application/json'
         }),
        body:JSON.stringify(blog)
    });
    if(response.status < 300){
        swal({
            title: "Notification", 
            text: "save or update successful!", 
            type: "success"
          },
        function(){ 
            window.location.replace('blog.html')
        });
    }
    else{
        swal({
            title: "Notification", 
            text: "save or update error!", 
            type: "error"
          },
        function(){ 
        });
    }
}

async function deleteBlog(id){
    var url = 'http://localhost:8080/api/admin/deleteBlog?id='+id;
    const response = await fetch(url, {
        method: 'DELETE',
        headers: new Headers({
            'Authorization': 'Bearer ' + token
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
            text: "can't delete this blog!", 
            type: "error"
            },
        function(){ 
            window.location.reload();
        });
    }
}
