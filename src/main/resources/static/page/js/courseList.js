let courseList = new Vue({
    el: '#courseList',
    data: function () {
        return {
            studentDetails:'',
            //分页数据
            page:{
                pageSize:5,
                currentPage:1,
                courses:'',
                college:'',
                major:'',
            },
            //选中行的记录id
            checkedNames:'',
            //搜索输入框
            searchInput3:"",
            //默认选中
            selected: 'courses',
            //下拉框选项
            options3: [
                { text: '课程', value: 'courses' },
                { text: '学院', value: 'college' },
                { text: '专业', value: 'major' },
            ],
            // 定义变量
            orderId:'',
            courseDetail:[],
            studentList:[],
            //搜索条件
            searchDate:{
                courses:'',
                college:'',
                major:'',
            },
        }
    },
    created: function () {
        this.initTable();
    },
    methods: {
        //初始化表格
        initTable(){
            let url='/getAllCourse';
            callAxiosGet(url,this.page,this.getListSuc,this.Fail);
        },
        //初始化
        refresh(){
            this.initialize();
            this.initTable();
        },
        //清空搜索条件
        initialize(){

            this.page.courses='';
            this.page.college='';
            this.page.major='';
            /*  */
            this.searchDate.courses='';
            this.searchDate.college='';
            this.searchDate.major='';
        },
        // 查询大一年级
        firstCourseList(){
            let url='/firstCourse';
            callAxiosGet(url,this.page,this.getListSuc,this.Fail);
        },
        // 查询大二年级
        secondCourseList(){
            let url='/secondCourse';
            callAxiosGet(url,this.page,this.getListSuc,this.Fail);
        },
        // 查询大三年级
        thirdCourseList(){
            let url='/thirdCourse';
            callAxiosGet(url,this.page,this.getListSuc,this.Fail);
        },
        // 查询大四年级
        fourthCourseList(){
            let url='/fourthCourse';
            callAxiosGet(url,this.page,this.getListSuc,this.Fail);
        },
        // 修改课程所有信息
        editCourseDetails(id){
            let url='/editCourseDetail?id='+id;
            callAxiosGetNoParam(url,this.getEditCourseDetail,this.Fail);
        },

        // 修改课程所有信息
        removeCourse(id) {
            var confirm_ = confirm('确认？');
            if (confirm_) {
                let url = '/removeCourse?id=' + id;
                callAxiosGetNoParam(url, this.getDeleteCourseDetail, this.Fail);
            }
        },
        getDeleteCourseDetail(res){
            if(res===1){
                alert("删除成功！");
                this.initTable();
            } else {
                alert("删除失败！");
            }
        },
        // 获取到课程信息之后
        getEditCourseDetail(res){
            let that=this;
            if(res.status===200){
                that.courseDetail=res.data;

            }else{
                alert(res.message);
            }
        },

        // 新增课程
        addCourse(){
            var college = $("#college").val();
            var courses = $("#courses").val();
            var grade = $("#grade").val();
            var major = $("#major").val();
            $.ajax({
                type:'post',
                url:'/addCourse',
                data:{
                    "college":college,
                    "courses":courses,
                    "grade":grade,
                    "major":major
                },
                dataType:'JSON',
                success:function (data) {
                    alert("成功"+data.data[0]+"条"+","+"异常"+data.data[1]+"条"+","+"不符合条件"+data.data[2]+"条");
                }
            })
            callAxiosGet(url,this.page,this.getListSuc,this.Fail);
        },

        to_page(pn) {
            let that=this;
            axios.get('/getAllCourse', {
                params: {
                    currentPage:pn,
                    pageSize: that.page.pageSize,

                    courses : this.searchDate.courses,
                    college :this.searchDate.college,
                    major :this.searchDate.major,
                }
            }).then(res => {
                $(':radio').removeAttr("checked");
                that.courses="";
                that.checkedNames=[];
                that.studentList = res.data.data;
            }, err => {
            })
        },
        //查询事件
        searchBtn3(){
            if(this.selected==='courses'){
                this.initialize();
                this.searchDate.courses=this.searchInput3;
            }
            else if(this.selected==='college'){
                this.initialize();
                this.searchDate.college=this.searchInput3;
            }
            else if(this.selected==='major'){
                this.initialize();
                this.searchDate.major=this.searchInput3;
            }
            else {
                this.initialize();
            }


            //查询条件
            this.page.currentPage=1;

            this.page.courses=this.searchDate.courses;
            this.page.college=this.searchDate.college;
            this.page.major=this.searchDate.major;
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

        editCourses(courses){
            let url='/editCourses';
            callAxiosGet(url,this.getCourseSuc,this.Fail);
        },

        getCourseSuc(res){
            if (res.status===200){

            } else {
            alert("你没有权限！");}
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

