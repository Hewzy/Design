let loginPage = new Vue({
    el: '#loginPage',
    data: function () {
        return {
            tb_name:'',
            tb_password:'',
            //默认选中
            roleId: '1',
            //下拉框选项
            options: [],
        }
    },
    created: function (){
        this.initRole()
    },

    methods: {
        initRole(){
            let url='/getAllRole';
            callAxiosGetNoParam(url,this.getRoleSuc,this.Fail)
        },
        getRoleSuc(res){
            this.options=res.data;
        },
        //登录
        doLogin(){
            let url='/doLogin';
            callAxiosGet(url,{name:this.tb_name,password:this.tb_password,roleId:this.roleId},this.Suc,this.Fail)
        },

        //接口连通
        Suc(res){
            if(res.status===200){
                alert(res.message);
                window.location.href = "/index";
            }else{
                alert(res.message);
            }
        },
        //接口未连通
        Fail(err){
            console.log("网络连接错误")
        },
    }
});


