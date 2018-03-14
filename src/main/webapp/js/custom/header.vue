<template>
  <div>
    <el-row>
      <el-col style="border: 1px solid;text-align: center;">
        <span>头部</span>
      </el-col>
      <el-col>
        <el-button type="primary" @click="logout">退出</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    methods: {
      logout(){
        location.href = '/account/ns/logout'
      }
    }
  }
</script>
