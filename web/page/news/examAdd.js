layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;
     var UserName=window.sessionStorage.getItem("user");
    var userId=window.sessionStorage.getItem("id");
     $("#userName").val(UserName);
    $("#userId").val(userId);

    //用于同步编辑器内容到textarea
    layedit.sync(editIndex);

    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());
    $("#questionTime").val(submitTime);
    laydate.render({
        elem: '#release',
        type: 'datetime',
        trigger : "click",
        done : function(value, date, endDate){
            submitTime = value;
        }
    });
    form.verify({
        newsName : function(val){
            if(val == ''){
                return "文章标题不能为空";
            }
        },
        content : function(val){
            if(val == ''){
                return "文章内容不能为空";
            }
        }
    })
    //预览
    form.on("submit(look)",function(){
        layer.alert("");
        return false;
    })

    //提交表单的方法
    form.on('submit(addNews)', function (data) {
        // var UserName=window.sessionStorage.getItem("user");
        // $("#UserName").html(UserName);
        // $("#questionTime").html(submitTime);

        var formdata = new FormData(document.getElementById("upload-form"));
        $.ajax({
            //cache : true,
            type : "post",
            url : "/ren/upload.action",
            //async : false,
            data : formdata,// 你的formid
            contentType: false,   //jax 中 contentType 设置为 false 是为了避免 JQuery 对其操作，从而失去分界符，而使服务器不能正常解析文件
            processData: false,   //当设置为true的时候,jquery ajax 提交的时候不会序列化 data，而是直接使用data
            error : function(request) {
                layer.alert('操作失败', {
                    icon: 2,
                    title:"提示"
                });
            },
            success: function (d)  {
                if (ret.msg == "成功")  {
                    layer.alert('成功', {
                        icon: 2,
                        title:"提示"
                    });
                   layer.closeAll();
                   layer.close(index);
                    //刷新父页面
                    parent.location.reload();
                   //window.location.href="/login";
                } else {
                    layer.alert('失敗', {
                        icon: 2,
                        title:"提示"
                    });
                }
            }
        })
        return false;
    })

    //创建一个编辑器
    var editIndex = layedit.build('news_content',{
        height : 535,
        uploadImage : {
            url : "../../json/newsImg.json"
        }
    });

})