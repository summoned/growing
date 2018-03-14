<template>
  <div>
    <header>
      <topheader></topheader>
    </header>
    <main style="display:flex;">
      <aside style="width:190px;overflow:auto;">
        <sidebar></sidebar>
      </aside>
      <section>
        <div>
          <router-view></router-view>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
  export default {
    components: {
      'sidebar': require('./sidebar.vue').default,
      'topheader': require('./header.vue').default,
    }
  }
</script>
