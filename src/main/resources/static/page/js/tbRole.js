let roleManagement = new Vue({
    el: '#roleManagement',
    data: function () {
        return {
            checkedId:[],
            //分页数据
            page:{
                pageSize:5,
                currentPage:1,
            },
            //选中行的记录id
            checkedDate:"",

            //角色数据
            roleDate:[],

            //模态框数据
            modalData:{
            },
        }
    },
    created: function () {
        this.initTable();
    },



    methods: {
        //初始化表格
        initTable() {
            let url = '/rolePage';
            callAxiosGet(url, this.page, this.getListSuc, this.Fail);
        },
        //新建角色
        creat() {
            $('.select2').select2();
            //清除表单数据（表单完整重置（表单的数据，表单的样式））
            $('#myModalLabel').html("添加");
            $('#id').val('');
            $('#firstname').val('');
            $('.select2').val([]).trigger("change");
            $('#editModal').modal('show');
        },
        // 编辑角色
        edit(roleId,roleName) {
            $('.select2').select2();
            $('#myModalLabel').html("编辑");
            $('#id').val(roleId);
            $('#firstname').val(roleName);
            getMyPermission(roleId,roleName);
            $('.select2').val([]).trigger("change");
            $('#editModal').modal('show');
            },
        //删除角色
        del(roleId) {
            $('#myModalLabel').html("删除");
            $('#id').val(roleId);
            deletRole (roleId);
            $('#delModal').modal('show');
        },


        /*根据页码，查询到要显示的数据*/
        to_page(pn) {
            let that=this;
            axios.get('/rolePage', {
                params: {
                    currentPage:pn,
                    pageSize: that.page.pageSize
                }
            }).then(res => {
                that.roleDate = res.data.data;
            }, err => {
                console(err);
            })
        },

        //获取成功
        getListSuc(res) {
            let that = this;
            if (res.status === 200) {
                that.roleDate = res.data;
            } else {
                alert(res.message);
            }
        },
    }

});

//保存
function save() {
    var permissionId = $('.select2').val();
    var strPermissionId =permissionId.join(',');
    var id =$('#id').val();
    var roleName =$('#firstname').val();
    if (roleName!=""){
        $.ajax({
            type:"post",
            url:"/roleUpdate",
            dataType:"json",
            data: {roleId:id,roleName:roleName,permissionId:strPermissionId},
            success:function (result) {
                $("#editModal").modal("hide");
                roleManagement.initTable();
                if (result.data == "update"){
                    alert("修改成功")
                } else if (result.data == "insert"){
                    alert("增加成功")
                }
            }
        })
    }
    else alert("请把数据填写完整")
}
//删除
function deletRole (roleId) {
    $.ajax({
        url:"/roleDeletById",
        data:"roleId="+roleId,
        type:"GET",
        contentType:'application/json',
        success:function (result) {
            if (result.status ==200){
                alert(result.message)
                roleManagement.initTable();
            } else
                alert("删除失败")

        }
    })

}
//获取当前用户的权限,select初始化需要[1,2,3]这个格式
function getMyPermission(roleId){
    $.ajax({
        url:"/rolePermission",
        data:"roleId="+roleId,
        type:"GET",
        success:function(result){
            $('.select2').select2();
            let data=result.data;
            let element = document.getElementById("permission");
            let len=element.options.length;
            var value=new Array()
            for (let i=0;i<data.length;i++){
                for (let j=0;j<len;j++){
                    if (element.options[j].value==data[i].permissionId){
                        value.push(data[i].permissionId)
                    }
                }
            }
            $('.select2').val(value).trigger("change");
        }
    })


    function toJSONString(jsonObj) {
        var jStr = "{";
        for(var item in jsonObj){
            jStr += "'"+item+"':'"+jsonObj[item]+"',";
        }
        return jStr.substring(0,jStr.length-1)+'}';
    }
}


