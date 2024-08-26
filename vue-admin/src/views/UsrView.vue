<template>
    <div>
        <!-- 基础表格 -->
        <!-- <table>
            <tr>
                <td>id</td>
                <td>name</td>
                <td>password</td>
            </tr>
            <tr v-for="user in users">
                <td>{{ user.id }}</td>
                <td>{{ user.name }}</td>
                <td>{{ user.password }}</td>
            </tr>
        </table> -->
    
        <!-- 应用element-ui的表格 -->
        <div class="table" id="table-wrapper">
            <el-table
            :data="users"
            stripe
            style="width: 100%">
                <el-table-column
                label="ID"
                prop="id">
                </el-table-column>
                <el-table-column
                label="Name"
                prop="name">
                </el-table-column>
                <el-table-column
                label="Birthday"
                prop="password">
                </el-table-column>
            </el-table>
        </div>
        
        <!-- 根据ID进行查询 -->
        <div style="margin:10px">
        输入ID进行查询: 
        <el-input v-model="queryId" placeholder="请输入ID" id="queryId" style="width:180px"></el-input>
        <el-button type="primary" @click="findUser(queryId)">查询</el-button>
            <table class="querytable">
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Birthday</td>
            </tr>
            <tr>
                <td>{{ this.queryData.id }}</td>
                <td>{{ this.queryData.name }}</td>
                <td>{{ this.queryData.password }}</td>
            </tr>
            </table>
        </div>

        <!-- 根据ID进行删除 -->
        <div style="margin:10px">
        输入ID进行删除: 
        <el-input v-model="deleteId" placeholder="请输入ID以进行删除" id="deleteId" style="width:180px"></el-input>
        <el-button type="primary" @click="deleteUser(deleteId)">删除</el-button>
        </div>
        
        <!-- 添加用户-->
        <div class="add" style="margin:10px">
        ID: 
        <el-input v-model="addId" placeholder="请输入ID" id="addId" style="width:180px"></el-input> 
        用户名: 
        <el-input v-model="addName" placeholder="请输入用户名" id="addName" style="width:180px"></el-input>
        生日: 
        <el-input v-model="addPassword" placeholder="请输入生日" id="addPassword" style="width:180px"></el-input>
        <el-button type="primary" @click="addUser(addId, addName, addPassword)">添加</el-button>
        </div>

        <!-- 更新用户 -->
        <div class="update" style="margin:10px">
        ID: 
        <el-input v-model="updateId" placeholder="请输入ID" id="updateId" style="width:180px"></el-input> 
        用户名: 
        <el-input v-model="updateName" placeholder="请输入用户名" id="updateName" style="width:180px"></el-input>
        生日: 
        <el-input v-model="updatePassword" placeholder="请输入生日" id="updatePassword" style="width:180px"></el-input>
        {{ updateId }}  {{ updateName }}  {{ updatePassword }}
        <el-button type="primary" @click="updateUser(updateId, updateName, updatePassword)">更新</el-button>
        </div>
    </div>
</template>

<style scoped>
.querytable{
    width: 100%;
    border-collapse: collapse;
    margin-top:30px;
    margin-bottom:30px;
}

tr{
    border-width: 2px;
    border-color: #9bb5d0; /* 蓝色背景 */
    border-style: solid;
    border-radius: 5px;
    color:black; /* 白色字体 */
    font-weight: bold; /* 粗体字 */
    text-align: center; /* 居中对齐 */
    padding: 10px; /* 设置内边距 */
}

td{
    border: 1px solid #ccc; /* 设置边框 */
    padding: 10px; /* 设置内边距 */
}

</style>

<script>
import { affixProps } from 'element-plus';
import axios from 'axios';


export default ({
    name:"user",
    data(){        
        return {
            users:[],
            tableDatas:[
                { addId : "" },
                { addName : "" },
                { addPassword : "" }
            ],
            addId:"",
            addName:"",
            addPassword:"",
            pageNum:1,
            pageSize:5,
            queryId:"",
            queryData:[],
            deleteId:"",
            updateId:"",
            updateName:"",
            updatePassword:"",
        }
    },
    created() {
        var that = this;
        axios.get('http://localhost:8081/usr')
        .then(response=>{
            that.users = response.data
        })
        .catch(err=>{
            error.value = err
        })
    },
    methods:{
        findUser(queryId){
            axios({
                url:"http://localhost:8081/usr/"+queryId,
                method:'GET',
            })
            .then(res=>{
                this.queryData=res.data
                console.log(this.queryData)
            })
        },
        deleteUser(deleteId){
            this.$confirm("此操作不可恢复, 是否继续?", "提示", {
            closeOnClickModal: false,
            type: "warning"
            }).then(() => {
                    axios({
                    url:"http://localhost:8081/usr/items/"+deleteId,
                    method:'DELETE',
                    }).then(() => { 
                        if(res.data.status!==200){
                            return this.$message.error('删除用户失败！');
                        }
                        this.$message.success("删除成功");
                    });
                }).catch(() => {
                this.$message({
                type: 'info',
                message: '已取消删除'
            });          
            }); 
        },
        addUser(addId, addName, addPassword){
            var url = "http://localhost:8081/usr/add";
            axios.post(url,{id:addId, name:addName, password:addPassword});
        },
        updateUser(updateId, updateName, updatePassword){
            var url = "http://localhost:8081/usr/update/"+updateId;
            axios.put(url,{id:updateId, name:updateName, password: updatePassword});
        },
    },
    
})
</script>
