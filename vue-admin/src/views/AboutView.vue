<template>
  <div class="about">
    <h1>This is an about page</h1>
  </div>


  <el-input placeholder="请输入用户名"></el-input>

  
  <!-- 查询表单 -->
  <el-form :inline="true" :model="queryForm" class="demo-form-inline">
  <el-form-item label="用户名">
    <el-input v-model="queryForm.name" placeholder="请输入用户名"></el-input>
  </el-form-item>
  <el-form-item label="密码">
    <el-select v-model="queryForm.password" placeholder="请输入密码">
      <el-option label="区域一" value="shanghai"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item>
    <el-button type="primary">查询</el-button>
  </el-form-item>
</el-form>

<!-- 用户列表 -->

</template>

<script>
import axios from 'axios';
export default{
  name:userIndex,
  data(){
    return{
      queryForm:{
        "name":Wang,
        "password":1231,
      }
    }
  }
}
</script>
