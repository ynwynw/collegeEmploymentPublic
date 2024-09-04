	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import news from '@/views/news/list'
	import yunxuanjiangshipin from '@/views/yunxuanjiangshipin/list'
	import daxueshengyonghu from '@/views/daxueshengyonghu/list'
	import gangweiyingpin from '@/views/gangweiyingpin/list'
	import qiyeyonghu from '@/views/qiyeyonghu/list'
	import zaixianzixun from '@/views/zaixianzixun/list'
	import config from '@/views/config/list'
	import mianshiyaoqing from '@/views/mianshiyaoqing/list'
	import users from '@/views/users/list'
	import xiaozhaogangweifabu from '@/views/xiaozhaogangweifabu/list'
	import qiyerenzheng from '@/views/qiyerenzheng/list'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/news',
			name: '新闻资讯',
			component: news
		}
		,{
			path: '/yunxuanjiangshipin',
			name: '云宣讲视频',
			component: yunxuanjiangshipin
		}
		,{
			path: '/daxueshengyonghu',
			name: '大学生用户',
			component: daxueshengyonghu
		}
		,{
			path: '/gangweiyingpin',
			name: '岗位应聘',
			component: gangweiyingpin
		}
		,{
			path: '/qiyeyonghu',
			name: '企业用户',
			component: qiyeyonghu
		}
		,{
			path: '/zaixianzixun',
			name: '在线咨询',
			component: zaixianzixun
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		,{
			path: '/mianshiyaoqing',
			name: '面试邀请',
			component: mianshiyaoqing
		}
		,{
			path: '/users',
			name: '管理员',
			component: users
		}
		,{
			path: '/xiaozhaogangweifabu',
			name: '校招岗位发布',
			component: xiaozhaogangweifabu
		}
		,{
			path: '/qiyerenzheng',
			name: '企业认证',
			component: qiyerenzheng
		}
		]
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
