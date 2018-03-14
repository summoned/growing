import axios from 'axios'

export default {
  test(){
    return axios.get('/call/test')
  },

  testDb(){
    return axios.get('/call/testDb')
  },

  login(data){
    return axios.post('/account/ns/login.ajax?username=' + data.username + '&password=' + data.password)
  },
}
