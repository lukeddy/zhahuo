<template>
  <div class="container">
    <div class="home wrapper-home">
      <div class="block">
        <el-carousel height="500px">
          <el-carousel-item v-for="item in images" :key="item">
            <img :src="item" />
          </el-carousel-item>
        </el-carousel>
      </div>
    </div>
    <div class="home-box-red">
      <div class="red-product">
        <div class="red-product-name">
          <div class="nav-red-product">
            <h3>热门商品</h3>
            <span class="iconfont">&#xe615;</span>
          </div>
        </div>
        <div class="red-product-show">
          <div>
            <ul class="red-product-list">
              <li
                @click="itemClick(item)"
                class="red-product-item"
                v-for="(item,index) in product"
                :key="index"
              >
                <div class="product-box-item">
                  <div class="hot-product-img">
                    <div class="item-img">
                      <img :src="item.pimage" alt="123" />
                    </div>
                    <h4 class="hot-pro-title">{{item.pname}}</h4>
                  </div>
                  <div class="hot-pro-text"></div>
                  <div class="hot-pro-price">
                    <span class="price-iconfont iconfont"></span>
                    <span class="hot-price">{{item.marketPrice}}</span>
                  </div>
                  <div></div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="home-box-like"></div>
    <div class="wrapper-end">
      <div class="end-p">
        <div class="end-d"></div>
        <span class="iconfont">&#xe645;</span>
      </div>
    </div>
  </div>
</template>

<script>
import image1 from "@/assets/images/slideshow/1.jpg";
import image2 from "@/assets/images/slideshow/2.jpg";
import image3 from "@/assets/images/slideshow/3.jpg";
import image4 from "@/assets/images/slideshow/4.jpg";
import image5 from "@/assets/images/slideshow/5.jpg";
export default {
  data() {
    return {
      product: [],
      images: [image1, image2, image3, image4, image5]
    };
  },
  async mounted() {
    const { status, data } = await this.$axios.post(
      "http://localhost:10010/api/search/page/productPage",
      {
        page: 1,
        rows: 8
      }
    );
    if (status === 200) {
      this.product = data.currentPage;
    } else {
      console.log("this page loading fail");
    }
  },
  methods: {
    async itemClick(item) {
      console.log(item.pid);
      window.location.href = "/item?pid=" + item.pid;
    }
  }
}
</script>

<style lang="scss">
@import "@/assets/css/index/index.scss";
@import "@/assets/css/index/redproduct.scss";
@import "@/assets/css/index/enter.scss";
</style>
