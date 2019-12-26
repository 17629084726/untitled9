var form, $,areaData;
layui.config({
    base : "../../js/"
}).extend({
    "address" : "address"
})
layui.use(['form','layer','upload','laydate',"address"],function(){
    form = layui.form;
    $ = layui.jquery;
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        upload = layui.upload,
        laydate = layui.laydate,
        address = layui.address;
    var id=window.sessionStorage.getItem("id");
    //$("#id").html(id);
    $("#userId").val(id);
    alert(id);
    //上传头像
    upload.render({
        elem: '.userFaceBtn',
        url: '../../json/userface.json',
        method : "get",  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
        done: function(res, index, upload){
            var num = parseInt(4*Math.random());  //生成0-4的随机数，随机显示一个头像信息
            $('#userFace').attr('src',res.data[num].src);
            window.sessionStorage.setItem('userFace',res.data[num].src);
        }
    });

    //添加验证规则
    form.verify({
        userBirthday : function(value){
            if(!/^(\d{4})[\u4e00-\u9fa5]|[-\/](\d{1}|0\d{1}|1[0-2])([\u4e00-\u9fa5]|[-\/](\d{1}|0\d{1}|[1-2][0-9]|3[0-1]))*$/.test(value)){
                return "出生日期格式不正确！";
            }
        }
    })
    //选择出生日期
    laydate.render({
        elem: '.userBirthday',
        format: 'yyyy年MM月dd日',
        trigger: 'click',
        max : 0,
        mark : {"0-12-15":"生日"},
        done: function(value, date){
            if(date.month === 12 && date.date === 15){ //点击每年12月15日，弹出提示语
                layer.msg('今天是我的生日，也是考试系统2.0的发布日，快来送上祝福吧！');
            }
        }
    });

    //提交个人资料
    form.on("submit(changeUser)",function(data){
        var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
        var formdata = new FormData(document.getElementById("userInfo-form"));
         var id=window.sessionStorage.getItem("id");
         //$("#id").html(id);
        $("#id").val(id);
        var key,userInfoHtml = '';
        userInfoHtml = {
            'realName' : $(".realName").val(),
            'userName' : $(".userName").val(),
            'userSex' : data.field.sex,
            'phoneNumber' : $(".phoneNumber").val(),
            'userBirthday' : $(".userBirthday").val(),
            'userGrade' : $(".userGrade").val(),
            'userAdress' : $(".userAdress").val(),
            'userEmail' : $(".userEmail").val(),
            'userDesc' : $(".userDesc").val(),
            'userHobby':data.field.userHobby,
        };
            console.log(id);
            $.ajax(
                {
                    url: "/ren/updatetable.action",
                    data: formdata,
                    dataType: "json",
                    type: "post",
                    //contentType: "application/json",
                    contentType: false,   //jax 中 contentType 设置为 false 是为了避免 JQuery 对其操作，从而失去分界符，而使服务器不能正常解析文件
                    processData: false,   //当设置为true的时候,jquery ajax 提交的时候不会序列化 data，而是直接使用data
                    success: function (d) {
                        // d.msg == "success"
                        if (d>0) {
                            reid = d;
                            // $("#uploadImg").trigger("click");
                            // layer.msg("添加成功！")
                            layer.close(index);
                            layer.msg("提交成功！");
                            top.layer.closeAll();
                            // layer.close(layer.index)
                            //刷新父页面
                            parent.location.reload();
                            // location.href="/ren/tableuser.action"
                        } else {
                            layer.msg("添加失败")
                        }
                    }
                }
            )
            layer.close(index);
           layer.msg("提交成功！");
        //},2000);
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    })

    //修改密码
    form.on("submit(changePwd)",function(data){
        var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
        setTimeout(function(){
            layer.close(index);
            layer.msg("密码修改成功！");
            $(".pwd").val('');
        },2000);
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    })
})