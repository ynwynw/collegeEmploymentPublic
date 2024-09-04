const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
			menuList:[
				{
					name: '校招岗位发布管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'校招岗位发布',
							url:'/index/xiaozhaogangweifabuList'
						},
					]
				},
				{
					name: '新闻资讯管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'新闻资讯',
							url:'/index/newsList'
						},
					]
				},
				{
					name: '云宣讲视频管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'云宣讲视频',
							url:'/index/yunxuanjiangshipinList'
						},
					]
				},
			]
        }
    },
    getProjectName(){
        return {
            projectName: "基于SpringBoot高校毕业生招聘就业管理系统"
        } 
    }
}
export default config
