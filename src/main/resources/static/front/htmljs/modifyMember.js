layui.use(['layer','jquery'], function(){
    var layer = layui.layer;
    var $=layui.jquery;



    $("#member-registration").submit(function () {
        if (/^[\u4e00-\u9fa5]+$/.test($('#username').val())) {
            alert("账户不能输入汉字！");
            return false;
        }

        if (isNaN($('#tel').val())) {
            alert("联系电话请输入数字");
            return false;
        }

        var pwd = document.getElementById("newPwd").value;
        var pwd2 = document.getElementById("newPwd2").value;
        if (pwd !== pwd2) {
            layer.msg("修改后密码前后不一致");
            return false;
        }

        $.ajax({
            url:"/member/updateMemberInfo",
            type:"post",
            data: $("#member-registration").serialize(),
            async:false,
            error:function () {
                layer.msg("服务器异常");
            },
            success:function (reuslt) {
                if (reuslt.msg === "success") {
                    layer.msg("修改成功");
                    setTimeout(function () {
                        window.location.href="/model/toModifyMember";
                    },2000)
                }else {
                    layer.msg("旧密码不正确");
                }
            }
        })
        return false;
    })

    /***********************************************/

});



