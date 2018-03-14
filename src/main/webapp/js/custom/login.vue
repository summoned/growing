<template>
  <div>
    <div>登录页面</div>
    <div>
      <el-form action ="j_spring_security_check" :model="form" @submit.native.prevent="submit">
        <el-form-item label="账号">
          <el-input v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item>
          <button type="submit">
            <span>登录</span>
          </button>
          <el-button type="primary" @click="onRegister">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  import apiService from './demo-api'

  export default {
    data(){
      return {
        form: {
          username: '',
          password: ''
        }
      }
    },
    methods: {
      async submit(){
        console.log('submit')
        let result = await apiService.login(this.form).then(res => {
          if(res.status === 200){
            console.log('login success')

            setTimeout(() => {
              location.href = '/vue/#'
            }, 100)
          }else{
            console.log('errorMsg=' + res.data)
          }
        }).catch(err => {
          console.log('err=', err);
        })
      },
      onRegister(){
        alert('注册')
      }
    }
  }
</script>
