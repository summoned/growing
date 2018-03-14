<template>
  <div>
    <el-row>
      <el-col>
        <el-button type="primary" @click="test">测试</el-button>
      </el-col>
    </el-row>
  </div>

</template>

<script>
  import apiService from './demo-api'

  export default {
    methods: {
      test(){
        apiService.test().then(res => {
          alert('accept from server, msg =' + res.data);
        }).catch(err => {
          console.error(err)
        });
      }
    }
  }
</script>
