import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import "element-plus/dist/index.css";
// eslint-disable-next-line
import ElementPlus from "element-plus";
// import axios from "axios";

createApp(App).use(store).use(router).use(ElementPlus).mount("#app");
