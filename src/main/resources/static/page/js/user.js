function updateUserId(id) {
    $("#updateUserId").val(id);
    $.ajax({
        ContentType: "application/json;charset=UTF-8",
        type: "post",
        url: "/index/getUserById",
        data: {"userId": id},
        success: function (msg) {
            var user=msg["user"];
            /*var roleName=msg["roleName"];
            alert(roleName);*/
            $("#myName").val(user.userName);
            $("#myPassword").val(user.userPassword);
            $("#userRole").val(user.roleId);
            $("#userRole").html(user.tbRole.roleName);
        }
    })

}

function Values(id) {

    $("#deleteUserId").val(id);

}
function deleteUser() {
    var userId=$("#deleteUserId").val();
    $.ajax({
        ContentType: "application/json;charset=UTF-8",
        type: "post",
        url: "/index/deleteUser",
        data: {"userId": userId},
        success: function (msg) {
            if (msg == "success") {
                /*$("#tr_"+userId).remove();*/
                alert("删除成功")
                location.reload() ;

            } else {
                alert("删除失败");
            }
        }
    })
}

function addUser() {
    var userName=$("#userName").val();
    var userPassword=$("#userPassword").val();
    var roleId=$("#roleId").val();

    if(userName==""||userName==null){
        alert("用户名不可为空");
    }
    else if(userPassword==""||userPassword==null){
        alert("用户密码不可为空");
    }
    else if(roleId==""||roleId==null){
        alert("角色不可为空");
    }else{
        $.ajax({
            ContentType:"application/json;charset=UTF-8",
            type:"post",
            url:"/index/getUserByName",
            data:{"userName":userName},
            success:function (msg) {
                if(msg=="isExit"){
                    alert("该用户名已经存在");
                }else {
                    $.ajax({
                        ContentType:"application/json;charset=UTF-8",
                        type:"post",
                        url:"/index/addUser",
                        data:{"userName":userName,"userPassword":userPassword,"roleId":roleId},
                        success:function (msg) {
                            if(msg=="success"){
                                alert("添加成功")
                                $("#userName").val("")
                                $("#userPassword").val("")

                            }else {
                                alert("添加失败");
                            }
                        }
                    })
                }
            }
        })
    }
}

function save() {
    var userId=$("#updateUserId").val();
    var userName=$("#myName").val();
    var userPassword=$("#myPassword").val();
    var roleId=$("#myRole").val();

    if(userName==""||userName==null){
        alert("用户名不可为空");
    }
    else if(userPassword==""||userPassword==null){
        alert("用户密码不可为空");
    }
    else if(roleId==""||roleId==null){
        alert("角色不可为空");
    }else{
        $.ajax({
            ContentType:"application/json;charset=UTF-8",
            type:"post",
            url:"/index/editUser",
            data:{"userName":userName,"userPassword":userPassword,"roleId":roleId,"userId":userId},
            success:function (msg) {
                if(msg=="success"){
                    location.reload() ;
                    alert("修改成功");
                }
                else if(msg="mySelf"){
                    alert("修改成功，请重新登录");
                    window.location.href="/logout";
                }
                else {
                    alert("修改失败");
                }
            }
        })
    }

}
