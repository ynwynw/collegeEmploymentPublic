import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import newsList from '@/views/pages/news/list'
import daxueshengyonghuList from '@/views/pages/daxueshengyonghu/list'
import daxueshengyonghuDetail from '@/views/pages/daxueshengyonghu/formModel'
import daxueshengyonghuAdd from '@/views/pages/daxueshengyonghu/formAdd'
import daxueshengyonghuRegister from '@/views/pages/daxueshengyonghu/register'
import daxueshengyonghuCenter from '@/views/pages/daxueshengyonghu/center'
import qiyeyonghuList from '@/views/pages/qiyeyonghu/list'
import qiyeyonghuDetail from '@/views/pages/qiyeyonghu/formModel'
import qiyeyonghuAdd from '@/views/pages/qiyeyonghu/formAdd'
import qiyeyonghuRegister from '@/views/pages/qiyeyonghu/register'
import qiyeyonghuCenter from '@/views/pages/qiyeyonghu/center'
import yunxuanjiangshipinList from '@/views/pages/yunxuanjiangshipin/list'
import yunxuanjiangshipinDetail from '@/views/pages/yunxuanjiangshipin/formModel'
import yunxuanjiangshipinAdd from '@/views/pages/yunxuanjiangshipin/formAdd'
import qiyerenzhengList from '@/views/pages/qiyerenzheng/list'
import qiyerenzhengDetail from '@/views/pages/qiyerenzheng/formModel'
import qiyerenzhengAdd from '@/views/pages/qiyerenzheng/formAdd'
import xiaozhaogangweifabuList from '@/views/pages/xiaozhaogangweifabu/list'
import xiaozhaogangweifabuDetail from '@/views/pages/xiaozhaogangweifabu/formModel'
import xiaozhaogangweifabuAdd from '@/views/pages/xiaozhaogangweifabu/formAdd'
import mianshiyaoqingList from '@/views/pages/mianshiyaoqing/list'
import mianshiyaoqingDetail from '@/views/pages/mianshiyaoqing/formModel'
import mianshiyaoqingAdd from '@/views/pages/mianshiyaoqing/formAdd'
import gangweiyingpinList from '@/views/pages/gangweiyingpin/list'
import gangweiyingpinDetail from '@/views/pages/gangweiyingpin/formModel'
import gangweiyingpinAdd from '@/views/pages/gangweiyingpin/formAdd'
import zaixianzixunList from '@/views/pages/zaixianzixun/list'
import zaixianzixunDetail from '@/views/pages/zaixianzixun/formModel'
import zaixianzixunAdd from '@/views/pages/zaixianzixun/formAdd'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'newsList',
			component: newsList
		}
		, {
			path: 'daxueshengyonghuList',
			component: daxueshengyonghuList
		}, {
			path: 'daxueshengyonghuDetail',
			component: daxueshengyonghuDetail
		}, {
			path: 'daxueshengyonghuAdd',
			component: daxueshengyonghuAdd
		}
		, {
			path: 'daxueshengyonghuCenter',
			component: daxueshengyonghuCenter
		}
		, {
			path: 'qiyeyonghuList',
			component: qiyeyonghuList
		}, {
			path: 'qiyeyonghuDetail',
			component: qiyeyonghuDetail
		}, {
			path: 'qiyeyonghuAdd',
			component: qiyeyonghuAdd
		}
		, {
			path: 'qiyeyonghuCenter',
			component: qiyeyonghuCenter
		}
		, {
			path: 'yunxuanjiangshipinList',
			component: yunxuanjiangshipinList
		}, {
			path: 'yunxuanjiangshipinDetail',
			component: yunxuanjiangshipinDetail
		}, {
			path: 'yunxuanjiangshipinAdd',
			component: yunxuanjiangshipinAdd
		}
		, {
			path: 'qiyerenzhengList',
			component: qiyerenzhengList
		}, {
			path: 'qiyerenzhengDetail',
			component: qiyerenzhengDetail
		}, {
			path: 'qiyerenzhengAdd',
			component: qiyerenzhengAdd
		}
		, {
			path: 'xiaozhaogangweifabuList',
			component: xiaozhaogangweifabuList
		}, {
			path: 'xiaozhaogangweifabuDetail',
			component: xiaozhaogangweifabuDetail
		}, {
			path: 'xiaozhaogangweifabuAdd',
			component: xiaozhaogangweifabuAdd
		}
		, {
			path: 'mianshiyaoqingList',
			component: mianshiyaoqingList
		}, {
			path: 'mianshiyaoqingDetail',
			component: mianshiyaoqingDetail
		}, {
			path: 'mianshiyaoqingAdd',
			component: mianshiyaoqingAdd
		}
		, {
			path: 'gangweiyingpinList',
			component: gangweiyingpinList
		}, {
			path: 'gangweiyingpinDetail',
			component: gangweiyingpinDetail
		}, {
			path: 'gangweiyingpinAdd',
			component: gangweiyingpinAdd
		}
		, {
			path: 'zaixianzixunList',
			component: zaixianzixunList
		}, {
			path: 'zaixianzixunDetail',
			component: zaixianzixunDetail
		}, {
			path: 'zaixianzixunAdd',
			component: zaixianzixunAdd
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/daxueshengyonghuRegister',
		component: daxueshengyonghuRegister
	}
	,{
		path: '/qiyeyonghuRegister',
		component: qiyeyonghuRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
