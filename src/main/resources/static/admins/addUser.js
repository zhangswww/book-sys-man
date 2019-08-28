$(document).ready(function () {
    //给选择框赋值
    findAllRoleCategory();
    $("#addUserForm").validate({
        rules:{
            username:{
                required:true
            },
            password:{
                required:true
            },
            email:{
                required:true
            },
            phone:{
                required:true
            },
            birthday:{
                required:true
            },
            role:{
                required:true
            }
        } ,
        messages:{
            username:{
                required:"<font color='red'>请输入用户名</font>"
            },
            password:{
                required:"<font color='red'>请输入密码</font>"
            },
            email:{
                required:"<font color='red'>请输入邮箱</font>"
            },
            phone:{
                required:"<font color='red'>请输入手机号</font>"
            },
            birthday:{
                required:"<font color='red'>请输入生日</font>"
            },
            role:{
                required:"<font color='red'>请选择角色</font>"
            }
        }
    });

});

function findAllRoleCategory() {
    $.ajax({
        async: false,
        type: "get",
        //ajax的url必须写全路径名
        url: "/role",
        dataType: "json",
        success: function (data) {
            /*console.log(data);*/
            $("select[name='role']").empty();
            $("select[name='role']").append('<option value="">——请选择——</option>');
            for (var i = 0; i < data.length; i++) {
                var html = '<option value="' + data[i].id + '">';
                html += data[i].name + '</option>';
                $("select[name='role']").append(html);
            }
        },
        error: function (data) {
            /* alert(data.result);*/
        }
    });
};