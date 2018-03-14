const errorNotify = function(err){
  if(err){
    Vue.prototype.$notify.error({
      title: '异常',
      message: err.toString()
    })
  }
}

window.errorNotify = errorNotify
