function obtenerInfoBase() {
    const taskList = document.querySelector(".bodyTable");
    $.ajax({
        url: "http://localhost:8081/tasks",
        method: "GET",
        dataType: "json"
    })
        .done(
            function (data) {
                if (data.length) {
                    let html = "";
                    $.each(data, function(index, usuario) {
                        console.log(usuario.id + ' - ' + usuario.titulo + ' ' + usuario.descripcion);
                        const li = `
                        <tr>
                        <th scope="row">${usuario.id}</th>
                        <td>${usuario.titulo}</td>
                        <td>${usuario.descripcion}</td>
                      </tr>
                      `;
                      html += li;
                    });
                    taskList.innerHTML = html;
                }
            });
}
function validarForm(){
    var a = $("#taskFormControlInput1").val(),
    o = $("#taskFormControlTextarea1").val();
    if(a.length>0){
        if(o.length>0){
            return 1;
        }else{
            return 0;
        }
    }else{
        return 0;
    }
}
function validarForm2(){
    var a = $("#taskFormControlInput1").val(),
    e = $("#taskFormControlInput0").val(),
    o = $("#taskFormControlTextarea1").val();
    if(a.length>0){
        if(o.length>0){
            if(e.length>0){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }else{
        return 0;
    }
}


$(document).ready(function () {
    if(window.location.href == "http://localhost:8080/ApiRestDemo/"){
        obtenerInfoBase();
    }
    $("#addTask").on("click",
        function () {
            event.preventDefault();
            if (validarForm()) {
                console.log("correcto");
                var a = $("#taskFormControlInput1").val(),
                o = $("#taskFormControlTextarea1").val();
                var data = {
                    "titulo": a,
                    "descripcion": o
                  };
                  var jsonData = JSON.stringify(data);
                  $.ajax({
                    url: 'http://localhost:8081/savetask',
                    type: 'POST',
                    contentType: 'application/json',
                    data: jsonData,
                    success: function(response) {
                      console.log(response);
                      window.location.href = "http://localhost:8080/ApiRestDemo/"

                    },
                    error: function(error) {
                      console.log(error);
                      alert("Probablemente el Id no existe")
                    }
                  });

            }else{
                alert("Rellena el formulario")
            }
        }
    );

    $("#uptTask").on("click",
        function () {
            event.preventDefault();
            if (validarForm2()) {
                console.log("correcto");
                var a = $("#taskFormControlInput1").val(),
                o = $("#taskFormControlTextarea1").val(),e = $("#taskFormControlInput0").val();
                var data = {
                    "titulo": a,
                    "descripcion": o
                  };
                  var jsonData = JSON.stringify(data);
                  $.ajax({
                    url: 'http://localhost:8081/update/'+e,
                    type: 'PUT',
                    contentType: 'application/json',
                    data: jsonData,
                    success: function(response) {
                      console.log(response);
                      window.location.href = "http://localhost:8080/ApiRestDemo/"

                    },
                    error: function(error) {
                      console.log(error);
                    }
                  });

            }else{
                alert("Rellena el formulario")
            }
        }
    );
    $("#delTask").on("click",
        function () {
            event.preventDefault();
            var e = $("#taskFormControlInput0").val();
                  $.ajax({
                    url: 'http://localhost:8081/delete/'+e,
                    type: 'DELETE',
                    contentType: 'application/json',
                    data: "jsonData",
                    success: function(response) {
                      console.log(response);
                      window.location.href = "http://localhost:8080/ApiRestDemo/"

                    },
                    error: function(error) {
                      console.log(error);
                    }
                  });

        }
    );
});
