/*
* <!--<script src="admins/showBooks.js" th:src="@{/admins/showBooks.js}"></script>-->
* */
$(document).ready(function () {
    // alert("会不会走");
    //给选择框赋值
    findAllBookCategory();
    $("#bookCategoryForm").validate({
        rules:{
            bookCategory:{
                required:true
            }
        } ,
        messages:{
            bookCategory:{
                required:"请选择图书类别"
            }
        }
    });
});

function findAllBookCategory() {
    $.ajax({
        async: false,
        type: "post",
        url: "/admins/showBookCategory",
        dataType: "json",
        success: function (data) {
            console.log(data);
            // alert('ajax');
            $("select[name='bookCategory']").empty();
            $("select[name='bookCategory']").append('<option value="">——请选择——</option>');
            for (var i = 0; i < data.length; i++) {
                var html = '<option value="' + data[i].categoryId + '">';
                html += data[i].categoryName + '</option>';
                $("select[name='bookCategory']").append(html);
            }
        },
        error: function (data) {
            alert(data.result);
        }
    });
};