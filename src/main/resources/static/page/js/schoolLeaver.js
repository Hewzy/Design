let schoolLeaver = new Vue({
    el: '#schoolLeaver',
    data: function () {
        return {
            studentDetails:'',
            //分页数据
            page:{
                pageSize:5,
                currentPage:1,
                stuId:'',
                college:'',
                major:'',
                classes:'',
            },
            //选中行的记录id
            checkedNames:'',
            //搜索输入框
            searchInput3:"",
            //默认选中
            selected: 'stuId',
            //下拉框选项
            options3: [
                { text: '学号', value: 'stuId' },
                { text: '学院', value: 'college' },
                { text: '专业', value: 'major' },
                { text: '班级', value: 'classes' },
            ],
            // 定义变量
            orderId:'',
            studentList:[],
            orderListDate:[],

            //搜索条件
            searchDate:{
                stuId:'',
                college:'',
                major:'',
                classes:'',
            },
        }
    },
    created: function () {
        this.initTable();
    },
    methods: {
        //初始化表格
        initTable(){
            let url='/leaveStuList';
            callAxiosGet(url,this.page,this.getListSuc,this.Fail);
        },
        //初始化
        refresh(){
            this.initialize();
            this.initTable();
        },
        //清空搜索条件
        initialize(){

            this.page.stuId='';
            this.page.college='';
            this.page.major='';
            this.page.classes='';
            /*  */
            this.searchDate.stuId='';
            this.searchDate.college='';
            this.searchDate.major='';
            this.searchDate.classes='';
        },

        //学生详情
        stuDetailsEdit(){
            if (this.checkedNames!=null||this.checkedNames!="") {
                this.stuId=this.checkedNames;
                let url = "/stuDetail?stuId="+this.stuId;
                callAxiosGetNoParam(url,this.getDetailSuc,this.Fail);
            } else {
                alert("请选择有效数据");
            }
        },
        // 得到学生详情数据之后赋值
        getDetailSuc(res){
            let that=this;
            that.studentDetails = res.data;
        },

        // 删除学生学籍
        removeStu(stuIdPage){
            var confirm_ = confirm('确认？');
            if(confirm_){
                let url='/removeStu?stuId='+stuIdPage;
                callAxiosGetNoParam(url,this.removeStuSuc,this.Fail);
            }
        },
        // 删除学籍返回结果
        removeStuSuc(data){
            if (data.status===200) {
                    alert("删除成功");
                    this.refreshPage();
            } else {
                alert(data.data);
            }
        },

        //学生详情
        stuDetails(){
            if (this.checkedNames!=null||this.checkedNames!="") {
                this.stuId=this.checkedNames;
                let url = "/stuDetail?stuId="+this.stuId;
                callAxiosGetNoParam(url,this.getDetailSuc,this.Fail);
                $('#editModal').modal('show');
            } else {
                alert("请选择有效数据");
            }
        },
        // 得到学生详情数据之后赋值
        getDetailSuc(res){
            let that=this;
            that.studentDetails = res.data;
        },

        to_page(pn) {
            let that=this;
            axios.get('/stuList', {
                params: {
                    currentPage:pn,
                    pageSize: that.page.pageSize,

                    stuId : this.searchDate.stuId,
                    college :this.searchDate.college,
                    major :this.searchDate.major,
                    classes : this.searchDate.classes
                }
            }).then(res => {
                $(':radio').removeAttr("checked");
                that.stuId="";
                that.checkedNames=[];
                that.studentList = res.data.data;
            }, err => {
            })
        },
        //查询事件
        searchBtn3(){
            if(this.selected==='stuId'){
                let reg = /^\d{1,10}$/;
                this.initialize();
                if (reg.test(this.searchInput3)){
                    this.searchDate.stuId=this.searchInput3;
                }else {
                    alert("输入错误");
                }
            }

            else if(this.selected==='college'){
                this.initialize();
                this.searchDate.college=this.searchInput3;
            }
            else if(this.selected==='major'){
                this.initialize();
                this.searchDate.major=this.searchInput3;
            }
            else if(this.selected==='classes'){
                this.initialize();
                this.searchDate.classes=this.searchInput3;
            }
            else {
                this.initialize();
            }


            //查询条件
            this.page.currentPage=1;

            this.page.stuId=this.searchDate.stuId;
            this.page.college=this.searchDate.college;
            this.page.major=this.searchDate.major;
            this.page.classes=this.searchDate.classes;
            //初始化表格
            this.initTable();
        },

        // 接受到集合数据之后处理
        getListSuc(res){
            let that=this;
            if(res.status===200){
                that.studentList=res.data;

            }else{
                alert(res.message);
            }
        },

        //接口连通
        Suc(res){
            alert(res.message);
            this.initTable();
        },
        //接口未连通
        Fail(err){

        },
        //刷新页面
        refreshPage(){
            location.reload();
        }
    }
});

