<template>
  <div>
    <el-row>
      <el-col :span="24">
        <el-menu default-active="0" unique-opened class="el-menu-vertical-demo" @select="select">
          <template v-for="(menu,index) in menuItems">
            <el-submenu :key="menu.sref" :index="index.toString()" v-if="menu.submenu">
              <template slot="title">
                <span>{{menu.text}}</span>
              </template>
              <el-menu-item :key="submenu.sref" :index="index + '-' + _index" v-for="(submenu,_index) in menu.submenu">
                <span>{{submenu.text}}</span>
              </el-menu-item>
            </el-submenu>

            <el-menu-item :index="index.toString()" :key="menu.sref" v-else>
              <span>{{menu.text}}</span>
            </el-menu-item>
          </template>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    data(){
      return {
        menuItems: [
          {
            sref: '1',
            icon: '',
            text: '菜单1',
            submenu: [
              {
                sref: '1-1',
                icon: '',
                text: '子菜单1-1'
              },
              {
                sref: '1-2',
                icon: '',
                text: '子菜单1-2'
              },
              {
                sref: '1-3',
                icon: '',
                text: '子菜单1-3'
              }
            ]
          },
          {
            sref: '2',
            icon: '',
            text: '菜单2',
            submenu: [
              {
                sref: '2-1',
                icon: '',
                text: '子菜单2-1'
              },
              {
                sref: '2-2',
                icon: '',
                text: '子菜单2-2'
              },
              {
                sref: '2-3',
                icon: '',
                text: '子菜单2-3'
              }
            ]
          },
          {
            sref: '3',
            icon: '',
            text: '菜单3'
          },
          {
            sref: 'caller',
            icon: '',
            text: '后台调用'
          }
        ]
      }
    },
    methods: {
      select(val){
        let arr = val.split('-').map(index => parseInt(index, 10));
        let __sref = arr.length === 1 ? this.menuItems[arr[0]].sref : this.menuItems[arr[0]].submenu[arr[1]].sref;
        console.log(__sref);
        if(__sref === 'caller'){
          location.href = '/vue/#/' + __sref
        }
      }
    }
  }
</script>
