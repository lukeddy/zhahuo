<template>
  <div class="header-nav-list">
    <ul class="nav-container">
      <li v-for="(item,index) in nav" :key="index">
          <a href="javascript:void(0);"><span>在线商城</span></a>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
        nav: ['在线商城','在线商城','在线商城','在线商城','在线商城','在线商城']
    }
  }
}
</script>

<style>

</style>