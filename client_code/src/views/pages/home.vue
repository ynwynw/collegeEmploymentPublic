<template>
	<div>
		<div class="home_box">
			<!-- 云宣讲视频首页展示 -->
			<div class="homeList_view">
				<div class="homeList_title">云宣讲视频展示</div>
				<div class="home_list_one">
					<div class="home_item1 animation_box" v-if="yunxuanjiangshipinHomeList.length>0" @click="detailClick('yunxuanjiangshipin',yunxuanjiangshipinHomeList[0].id)">
						<div class="home_img_box">
							<img class="home_img" v-if="isHttp(yunxuanjiangshipinHomeList[0].fengmian)" :src="yunxuanjiangshipinHomeList[0].fengmian.split(',')[0]" alt="">
							<img class="home_img" v-else :src="yunxuanjiangshipinHomeList[0].fengmian?$config.url + yunxuanjiangshipinHomeList[0].fengmian.split(',')[0]:''" alt="">
						</div>
						<div class="home_content">
							<div class="home_title">
								{{yunxuanjiangshipinHomeList[0].shipinbiaoti}}
							</div>
							<div class="home_title">
								{{yunxuanjiangshipinHomeList[0].faburiqi}}
							</div>
							<div class="home_title">
								{{yunxuanjiangshipinHomeList[0].xingming}}
							</div>
						</div>
					</div>
					<div class="home_item2">
						<div class="item2_top animation_box" v-if="yunxuanjiangshipinHomeList.length>1" @click="detailClick('yunxuanjiangshipin',yunxuanjiangshipinHomeList[1].id)">
							<div class="home_img_box">
								<img class="home_img" v-if="isHttp(yunxuanjiangshipinHomeList[1].fengmian)" :src="yunxuanjiangshipinHomeList[1].fengmian.split(',')[0]" alt="">
								<img class="home_img" v-else :src="yunxuanjiangshipinHomeList[1].fengmian?$config.url + yunxuanjiangshipinHomeList[1].fengmian.split(',')[0]:''" alt="">
							</div>
							<div class="home_content">
								<div class="home_title">
									{{yunxuanjiangshipinHomeList[1].shipinbiaoti}}
								</div>
								<div class="home_title">
									{{yunxuanjiangshipinHomeList[1].faburiqi}}
								</div>
								<div class="home_title">
									{{yunxuanjiangshipinHomeList[1].xingming}}
								</div>
							</div>
						</div>
						<div class="item2_bottom animation_box" v-if="yunxuanjiangshipinHomeList.length>2" @click="detailClick('yunxuanjiangshipin',yunxuanjiangshipinHomeList[2].id)">
							<div class="home_img_box">
								<img class="home_img" v-if="isHttp(yunxuanjiangshipinHomeList[2].fengmian)" :src="yunxuanjiangshipinHomeList[2].fengmian.split(',')[0]" alt="">
								<img class="home_img" v-else :src="yunxuanjiangshipinHomeList[2].fengmian?$config.url + yunxuanjiangshipinHomeList[2].fengmian.split(',')[0]:''" alt="">
							</div>
							<div class="home_content">
								<div class="home_title">
									{{yunxuanjiangshipinHomeList[2].shipinbiaoti}}
								</div>
								<div class="home_title">
									{{yunxuanjiangshipinHomeList[2].faburiqi}}
								</div>
								<div class="home_title">
									{{yunxuanjiangshipinHomeList[2].xingming}}
								</div>
							</div>
						</div>
					</div>
					<div class="home_item3 animation_box" v-if="yunxuanjiangshipinHomeList.length>3" @click="detailClick('yunxuanjiangshipin',yunxuanjiangshipinHomeList[3].id)">
						<div class="home_img_box">
							<img class="home_img" v-if="isHttp(yunxuanjiangshipinHomeList[3].fengmian)" :src="yunxuanjiangshipinHomeList[3].fengmian.split(',')[0]" alt="">
							<img class="home_img" v-else :src="yunxuanjiangshipinHomeList[3].fengmian?$config.url + yunxuanjiangshipinHomeList[3].fengmian.split(',')[0]:''" alt="">
						</div>
						<div class="home_content">
							<div class="home_title">
								{{yunxuanjiangshipinHomeList[3].shipinbiaoti}}
							</div>
							<div class="home_title">
								{{yunxuanjiangshipinHomeList[3].faburiqi}}
							</div>
							<div class="home_title">
								{{yunxuanjiangshipinHomeList[3].xingming}}
							</div>
						</div>
					</div>
					<div class="home_item4">
						<div class="item4_top animation_box" v-if="yunxuanjiangshipinHomeList.length>4" @click="detailClick('yunxuanjiangshipin',yunxuanjiangshipinHomeList[4].id)">
							<div class="home_img_box">
								<img class="home_img" v-if="isHttp(yunxuanjiangshipinHomeList[4].fengmian)" :src="yunxuanjiangshipinHomeList[4].fengmian.split(',')[0]" alt="">
								<img class="home_img" v-else :src="yunxuanjiangshipinHomeList[4].fengmian?$config.url + yunxuanjiangshipinHomeList[4].fengmian.split(',')[0]:''" alt="">
							</div>
							<div class="home_content">
								<div class="home_title">
									{{yunxuanjiangshipinHomeList[4].shipinbiaoti}}
								</div>
								<div class="home_title">
									{{yunxuanjiangshipinHomeList[4].faburiqi}}
								</div>
								<div class="home_title">
									{{yunxuanjiangshipinHomeList[4].xingming}}
								</div>
							</div>
						</div>
						<div class="item4_bottom animation_box" v-if="yunxuanjiangshipinHomeList.length>5" @click="detailClick('yunxuanjiangshipin',yunxuanjiangshipinHomeList[5].id)">
							<div class="home_img_box">
								<img class="home_img" v-if="isHttp(yunxuanjiangshipinHomeList[5].fengmian)" :src="yunxuanjiangshipinHomeList[5].fengmian.split(',')[0]" alt="">
								<img class="home_img" v-else :src="yunxuanjiangshipinHomeList[5].fengmian?$config.url + yunxuanjiangshipinHomeList[5].fengmian.split(',')[0]:''" alt="">
							</div>
							<div class="home_content">
								<div class="home_title">
									{{yunxuanjiangshipinHomeList[5].shipinbiaoti}}
								</div>
								<div class="home_title">
									{{yunxuanjiangshipinHomeList[5].faburiqi}}
								</div>
								<div class="home_title">
									{{yunxuanjiangshipinHomeList[5].xingming}}
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="homeList_more_view" @click="moreClick('yunxuanjiangshipin')">
					<span class="homeList_more_text">查看更多</span>
					<el-icon><DArrowRight /></el-icon>
				</div>
			</div>
			<!-- 校招岗位发布首页展示 -->
			<div class="homeList_view">
				<div class="homeList_title">校招岗位发布展示</div>
				<div class="home_list_one">
					<div class="home_item1 animation_box" v-if="xiaozhaogangweifabuHomeList.length>0" @click="detailClick('xiaozhaogangweifabu',xiaozhaogangweifabuHomeList[0].id)">
						<div class="home_img_box">
							<img class="home_img" v-if="isHttp(xiaozhaogangweifabuHomeList[0].fengmian)" :src="xiaozhaogangweifabuHomeList[0].fengmian.split(',')[0]" alt="">
							<img class="home_img" v-else :src="xiaozhaogangweifabuHomeList[0].fengmian?$config.url + xiaozhaogangweifabuHomeList[0].fengmian.split(',')[0]:''" alt="">
						</div>
						<div class="home_content">
							<div class="home_title">
								{{xiaozhaogangweifabuHomeList[0].zhiweimingcheng}}
							</div>
							<div class="home_title">
								{{xiaozhaogangweifabuHomeList[0].gongsiyaoqiuxueli}}
							</div>
							<div class="home_title">
								{{xiaozhaogangweifabuHomeList[0].qiyemingcheng}}
							</div>
						</div>
					</div>
					<div class="home_item2">
						<div class="item2_top animation_box" v-if="xiaozhaogangweifabuHomeList.length>1" @click="detailClick('xiaozhaogangweifabu',xiaozhaogangweifabuHomeList[1].id)">
							<div class="home_img_box">
								<img class="home_img" v-if="isHttp(xiaozhaogangweifabuHomeList[1].fengmian)" :src="xiaozhaogangweifabuHomeList[1].fengmian.split(',')[0]" alt="">
								<img class="home_img" v-else :src="xiaozhaogangweifabuHomeList[1].fengmian?$config.url + xiaozhaogangweifabuHomeList[1].fengmian.split(',')[0]:''" alt="">
							</div>
							<div class="home_content">
								<div class="home_title">
									{{xiaozhaogangweifabuHomeList[1].zhiweimingcheng}}
								</div>
								<div class="home_title">
									{{xiaozhaogangweifabuHomeList[1].gongsiyaoqiuxueli}}
								</div>
								<div class="home_title">
									{{xiaozhaogangweifabuHomeList[1].qiyemingcheng}}
								</div>
							</div>
						</div>
						<div class="item2_bottom animation_box" v-if="xiaozhaogangweifabuHomeList.length>2" @click="detailClick('xiaozhaogangweifabu',xiaozhaogangweifabuHomeList[2].id)">
							<div class="home_img_box">
								<img class="home_img" v-if="isHttp(xiaozhaogangweifabuHomeList[2].fengmian)" :src="xiaozhaogangweifabuHomeList[2].fengmian.split(',')[0]" alt="">
								<img class="home_img" v-else :src="xiaozhaogangweifabuHomeList[2].fengmian?$config.url + xiaozhaogangweifabuHomeList[2].fengmian.split(',')[0]:''" alt="">
							</div>
							<div class="home_content">
								<div class="home_title">
									{{xiaozhaogangweifabuHomeList[2].zhiweimingcheng}}
								</div>
								<div class="home_title">
									{{xiaozhaogangweifabuHomeList[2].gongsiyaoqiuxueli}}
								</div>
								<div class="home_title">
									{{xiaozhaogangweifabuHomeList[2].qiyemingcheng}}
								</div>
							</div>
						</div>
					</div>
					<div class="home_item3 animation_box" v-if="xiaozhaogangweifabuHomeList.length>3" @click="detailClick('xiaozhaogangweifabu',xiaozhaogangweifabuHomeList[3].id)">
						<div class="home_img_box">
							<img class="home_img" v-if="isHttp(xiaozhaogangweifabuHomeList[3].fengmian)" :src="xiaozhaogangweifabuHomeList[3].fengmian.split(',')[0]" alt="">
							<img class="home_img" v-else :src="xiaozhaogangweifabuHomeList[3].fengmian?$config.url + xiaozhaogangweifabuHomeList[3].fengmian.split(',')[0]:''" alt="">
						</div>
						<div class="home_content">
							<div class="home_title">
								{{xiaozhaogangweifabuHomeList[3].zhiweimingcheng}}
							</div>
							<div class="home_title">
								{{xiaozhaogangweifabuHomeList[3].gongsiyaoqiuxueli}}
							</div>
							<div class="home_title">
								{{xiaozhaogangweifabuHomeList[3].qiyemingcheng}}
							</div>
						</div>
					</div>
					<div class="home_item4">
						<div class="item4_top animation_box" v-if="xiaozhaogangweifabuHomeList.length>4" @click="detailClick('xiaozhaogangweifabu',xiaozhaogangweifabuHomeList[4].id)">
							<div class="home_img_box">
								<img class="home_img" v-if="isHttp(xiaozhaogangweifabuHomeList[4].fengmian)" :src="xiaozhaogangweifabuHomeList[4].fengmian.split(',')[0]" alt="">
								<img class="home_img" v-else :src="xiaozhaogangweifabuHomeList[4].fengmian?$config.url + xiaozhaogangweifabuHomeList[4].fengmian.split(',')[0]:''" alt="">
							</div>
							<div class="home_content">
								<div class="home_title">
									{{xiaozhaogangweifabuHomeList[4].zhiweimingcheng}}
								</div>
								<div class="home_title">
									{{xiaozhaogangweifabuHomeList[4].gongsiyaoqiuxueli}}
								</div>
								<div class="home_title">
									{{xiaozhaogangweifabuHomeList[4].qiyemingcheng}}
								</div>
							</div>
						</div>
						<div class="item4_bottom animation_box" v-if="xiaozhaogangweifabuHomeList.length>5" @click="detailClick('xiaozhaogangweifabu',xiaozhaogangweifabuHomeList[5].id)">
							<div class="home_img_box">
								<img class="home_img" v-if="isHttp(xiaozhaogangweifabuHomeList[5].fengmian)" :src="xiaozhaogangweifabuHomeList[5].fengmian.split(',')[0]" alt="">
								<img class="home_img" v-else :src="xiaozhaogangweifabuHomeList[5].fengmian?$config.url + xiaozhaogangweifabuHomeList[5].fengmian.split(',')[0]:''" alt="">
							</div>
							<div class="home_content">
								<div class="home_title">
									{{xiaozhaogangweifabuHomeList[5].zhiweimingcheng}}
								</div>
								<div class="home_title">
									{{xiaozhaogangweifabuHomeList[5].gongsiyaoqiuxueli}}
								</div>
								<div class="home_title">
									{{xiaozhaogangweifabuHomeList[5].qiyemingcheng}}
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="homeList_more_view" @click="moreClick('xiaozhaogangweifabu')">
					<span class="homeList_more_text">查看更多</span>
					<el-icon><DArrowRight /></el-icon>
				</div>
			</div>
			<!-- 新闻资讯 -->
			<div class="newsList_view">
				<div class="newsList_title">新闻资讯</div>
				<div class="news_list_one">
					<div class="news_item animation_box" v-for="(item,index) in newsList" :key="index" @click="newsDetailClick(item.id)">
						<div class='news_img_box'>
							<img class="news_img" v-if="isHttp(item.picture)" :src="item.picture.split(',')[0]" alt="">
							<img class="news_img" v-else :src="item.picture?$config.url + item.picture.split(',')[0]:''" alt="">
						</div>
						<div class="news_content">
							<div class="news_title">{{item.title}}</div>
							<div class="news_text">{{item.introduction}}</div>
							<div class="news_time">{{item.addtime.split(' ')[0]}}</div>
						</div>
					</div>
				</div>
				<div class="news_more_view" @click="moreClick('news')">
					<span class="news_more_text">查看更多</span>
					<el-icon><DArrowRight /></el-icon>
				</div>
			</div>
		</div>
		<formModel ref="newsFormModelRef"></formModel>
	</div>
</template>

<script setup>
	import {
		ref,
		getCurrentInstance
	} from 'vue';
	import {
		useRouter
	} from 'vue-router';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const router = useRouter()
	//云宣讲视频首页展示
	const yunxuanjiangshipinHomeList = ref([])
	const getyunxuanjiangshipinHomeList = () => {
		context?.$http({
			url: 'yunxuanjiangshipin/list',
			method: 'get',
			params: {
				page: 1,
				limit: 6
			}
		}).then(res => {
			yunxuanjiangshipinHomeList.value = res.data.data.list
		})
	}
	//校招岗位发布首页展示
	const xiaozhaogangweifabuHomeList = ref([])
	const getxiaozhaogangweifabuHomeList = () => {
		context?.$http({
			url: 'xiaozhaogangweifabu/list',
			method: 'get',
			params: {
				page: 1,
				limit: 6
			}
		}).then(res => {
			xiaozhaogangweifabuHomeList.value = res.data.data.list
		})
	}
	//新闻资讯弹窗
	import formModel from './news/formModel'
	const newsFormModelRef = ref(null)
	//新闻资讯
	const newsList = ref([])
	const getNewsList = () => {
		context?.$http({
			url: 'news/list',
			method: 'get',
			params:{
				page:1,
				limit: 9
			}
		}).then(res=>{
			newsList.value = res.data.data.list
		})
	}
	const newsDetailClick = (id=null) => {
		if (id){
			newsFormModelRef.value.init(id)
		}
	}
	//判断图片链接是否带http
	const isHttp = (str) => {
        return str && str.substr(0,4)=='http';
    }
	//跳转详情
	const detailClick = (table,id) => {
		router.push(`/index/${table}Detail?id=${id}`)
	}
	const moreClick = (table) => {
		router.push(`/index/${table}List`)
	}
	const init = () => {
		//云宣讲视频首页展示
		getyunxuanjiangshipinHomeList()
		//校招岗位发布首页展示
		getxiaozhaogangweifabuHomeList()
		//新闻资讯
		getNewsList()
	}
	init()
</script>

<style lang="scss">
	.home_box {
		padding: 0;
		margin: 0 auto;
		background: #eee;
		display: flex;
		width: 100%;
		justify-content: space-between;
		align-items: flex-start;
		flex-wrap: wrap;
	}
	
	// 推荐
	.recomList_view {
		padding: 40px 7% 60px;
		margin: 0 auto;
		background: #eee;
		width: 100%;
		position: relative;
		order: 2;
		.recomList_title {
			padding: 0 0 20px;
			margin: 0px 0 0;
			color: #033561;
			font-weight: 500;
			width: auto;
			font-size: 30px;
			border-color: #2da065;
			border-width: 0 0 0px;
			border-style: solid;
			text-align: left;
		}
		// list
		.recommend_list_five {
			margin: 0 auto;
			flex-direction: row;
			display: flex;
			width: 100%;
			align-items: flex-start;
			.recommend_list_five_left {
				width: 75%;
				.item1 {
					cursor: pointer;
					display: flex;
					width: 100%;
					.recommend_img_box {
						width: 65%;
						font-size: 0;
						height: 320px;
						.recommend_img {
							object-fit: cover;
							width: 100%;
							height: 100%;
						}
					}
					.content {
						padding: 10px 20px;
						flex-direction: column;
						background: #fff;
						display: flex;
						width: 35%;
						line-height: 30px;
						justify-content: center;
						align-items: center;
						flex-wrap: wrap;
						text-align: center;
						height: 320px;
						.recommend_title1 {
							color: #000;
							font-weight: bold;
							width: 100%;
						}
						.recommend_title2 {
							color: #666;
							width: 100%;
						}
						.recommend_title3 {
							color: #666;
							width: 100%;
						}
						.recommend_title4 {
							color: #666;
							width: 100%;
						}
						.recommend_title5 {
							color: #666;
							width: 100%;
						}
						.recommend_price {
							color: #f00;
							width: 100%;
						}
						.recommend_five_bottom {
							display: flex;
							width: 100%;
							justify-content: center;
							align-items: center;
							.recommend_like {
								margin: 0 10px 0 0;
								color: #0266b5;
								display: flex;
								font-size: 16px;
								align-items: center;
								.like_icon {
									margin: 0 4px 0 0;
									color: inherit;
								}
								.like_num {
									color: inherit;
								}
							}
							.recommend_collect {
								margin: 0 10px 0 0;
								color: #ee7810;
								display: flex;
								font-size: 16px;
								align-items: center;
								.el-icon {
									margin: 0 4px 0 0;
									color: inherit;
								}
								.collect_num {
									color: inherit;
								}
							}
							.recommend_clickNum {
								margin: 0 10px 0 0;
								color: #4aac26;
								display: flex;
								font-size: 16px;
								align-items: center;
								.el-icon {
									margin: 0 4px 0 0;
									color: inherit;
								}
								.clickNum_num {
									color: inherit;
								}
							}
						}
					}
				}
				.left_bottom {
					display: flex;
					width: 100%;
					align-items: flex-start;
					.item2 {
						cursor: pointer;
						width: 33%;
						.content {
							padding: 20px;
							flex-direction: column;
							background: #fff;
							display: flex;
							width: 100%;
							line-height: 24px;
							justify-content: center;
							align-items: center;
							flex-wrap: wrap;
							text-align: center;
							height: 280px;
							.recommend_title1 {
								color: #000;
								font-weight: bold;
								width: 100%;
							}
							.recommend_title2 {
								color: #666;
								width: 100%;
							}
							.recommend_title3 {
								color: #666;
								width: 100%;
							}
							.recommend_title4 {
								color: #666;
								width: 100%;
							}
							.recommend_title5 {
								color: #666;
								width: 100%;
							}
							.recommend_price {
								color: #f00;
								width: 100%;
							}
							.recommend_five_bottom {
								display: flex;
								width: 100%;
								justify-content: center;
								align-items: center;
								.recommend_like {
									margin: 0 10px 0 0;
									color: #0266b5;
									display: flex;
									font-size: 16px;
									align-items: center;
									.like_icon {
										margin: 0 4px 0 0;
										color: inherit;
									}
									.like_num {
										color: inherit;
									}
								}
								.recommend_collect {
									margin: 0 10px 0 0;
									color: #ee7810;
									display: flex;
									font-size: 16px;
									align-items: center;
									.el-icon {
										margin: 0 4px 0 0;
										color: inherit;
									}
									.collect_num {
										color: inherit;
									}
								}
								.recommend_clickNum {
									margin: 0 10px 0 0;
									color: #4aac26;
									display: flex;
									font-size: 16px;
									align-items: center;
									.el-icon {
										margin: 0 4px 0 0;
										color: inherit;
									}
									.clickNum_num {
										color: inherit;
									}
								}
							}
						}
						.recommend_img_box {
							width: 100%;
							font-size: 0;
							height: 400px;
							.recommend_img {
								object-fit: cover;
								width: 100%;
								height: 100%;
							}
						}
					}
					.item3 {
						cursor: pointer;
						width: 67%;
						.recommend_img_box {
							width: 100%;
							font-size: 0;
							height: 460px;
							.recommend_img {
								object-fit: cover;
								width: 100%;
								height: 100%;
							}
						}
						.content {
							padding: 20px;
							flex-direction: column;
							background: #fff;
							display: flex;
							width: 100%;
							line-height: 24px;
							justify-content: center;
							align-items: center;
							flex-wrap: wrap;
							text-align: center;
							height: 220px;
							.recommend_title1 {
								color: #000;
								font-weight: bold;
							}
							.recommend_title2 {
								color: #666;
							}
							.recommend_title3 {
								color: #666;
							}
							.recommend_title4 {
								color: #666;
							}
							.recommend_title5 {
								color: #666;
							}
							.recommend_price {
								color: #f00;
							}
							.recommend_five_bottom {
								display: flex;
								justify-content: center;
								align-items: center;
								.recommend_like {
									margin: 0 10px 0 0;
									color: #0266b5;
									display: flex;
									font-size: 16px;
									align-items: center;
									.like_icon {
										margin: 0 4px 0 0;
										color: inherit;
									}
									.like_num {
										color: inherit;
									}
								}
								.recommend_collect {
									margin: 0 10px 0 0;
									color: #ee7810;
									display: flex;
									font-size: 16px;
									align-items: center;
									.el-icon {
										margin: 0 4px 0 0;
										color: inherit;
									}
									.collect_num {
										color: inherit;
									}
								}
								.recommend_clickNum {
									margin: 0 10px 0 0;
									color: #4aac26;
									display: flex;
									font-size: 16px;
									align-items: center;
									.el-icon {
										margin: 0 4px 0 0;
										color: inherit;
									}
									.clickNum_num {
										color: inherit;
									}
								}
							}
						}
					}
				}
			}
			.recommend_list_five_right {
				width: 25%;
				.item4 {
					cursor: pointer;
					width: 100%;
					.recommend_img_box {
						width: 100%;
						font-size: 0;
						height: 320px;
						.recommend_img {
							object-fit: cover;
							width: 100%;
							height: 100%;
						}
					}
					.content {
						padding: 20px;
						flex-direction: column;
						background: #fff;
						display: flex;
						width: 100%;
						line-height: 24px;
						justify-content: center;
						align-items: center;
						flex-wrap: wrap;
						text-align: center;
						height: 280px;
						.recommend_title1 {
							color: #000;
							font-weight: bold;
						}
						.recommend_title2 {
							color: #666;
						}
						.recommend_title3 {
							color: #666;
						}
						.recommend_title4 {
							color: #666;
						}
						.recommend_title5 {
							color: #666;
						}
						.recommend_price {
							color: #f00;
						}
						.recommend_five_bottom {
							display: flex;
							justify-content: center;
							align-items: center;
							.recommend_like {
								margin: 0 10px 0 0;
								color: #0266b5;
								display: flex;
								font-size: 16px;
								align-items: center;
								.like_icon {
									margin: 0 4px 0 0;
									color: inherit;
								}
								.like_num {
									color: inherit;
								}
							}
							.recommend_collect {
								margin: 0 10px 0 0;
								color: #ee7810;
								display: flex;
								font-size: 16px;
								align-items: center;
								.el-icon {
									margin: 0 4px 0 0;
									color: inherit;
								}
								.collect_num {
									color: inherit;
								}
							}
							.recommend_clickNum {
								margin: 0 10px 0 0;
								color: #4aac26;
								display: flex;
								font-size: 16px;
								align-items: center;
								.el-icon {
									margin: 0 4px 0 0;
									color: inherit;
								}
								.clickNum_num {
									color: inherit;
								}
							}
						}
					}
				}
				.five_more_view {
					cursor: pointer;
					color: #fff;
					background: #002648;
					display: flex;
					width: 100%;
					justify-content: center;
					align-items: center;
					flex-wrap: wrap;
					text-align: center;
					height: 400px;
					.five_more_text {
						border: 1px solid #fff;
						padding: 8px 30px;
					}
				}
			}
		}
		// list
		// animation
		.animation_box {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box:hover {
			transform: rotate(0deg) scale(0.95) skew(0deg, 0deg) translate3d(0px, -3px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		.animation_box img {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box img:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		// animation
	}
	// 推荐
	// 新闻资讯
	.newsList_view {
		padding: 40px 7% 0px;
		margin: 0 auto;
		background: #fff;
		width: 100%;
		position: relative;
		order: 3;
		height: auto;

		.newsList_title {
			padding: 0 0 8px;
			margin: 0 auto 20px;
			color: #033561;
			background: none;
			font-weight: 500;
			width: auto;
			font-size: 30px;
			border-color: #999;
			border-width: 0 0 0px;
			border-style: dashed;
			text-align: left;
		}
		// list
		.news_list_one {
			padding: 20px 10px 10px;
			margin: 20px 0 0;
			background: none;
			display: flex;
			width: 100%;
			justify-content: space-between;
			flex-wrap: wrap;
			.news_item {
				cursor: pointer;
				padding: 0 0 20px;
				margin: 0 20px 40px 0;
				background: #fff;
				display: flex;
				width: calc(32% - 20px);
				align-items: center;
				border-bottom: 1px solid rgba(0, 38, 72, .3);
				.news_img_box {
					overflow: hidden;
					width: 210px;
					height: 130px;
					.news_img {
						border: 0px solid #eee;
						object-fit: cover;
						width: 100%;
						height: 100%;
					}
				}
				.news_content {
					margin: 0 0 0 30px;
					display: flex;
					width: calc(100% - 240px);
					flex-wrap: wrap;
					.news_title {
						border: 1px solid #888;
						padding: 4px 10px;
						margin: 0 0 10px;
						overflow: hidden;
						color: #888;
						white-space: nowrap;
						font-weight: 500;
						width: 100%;
						font-size: 14px;
						text-overflow: ellipsis;
						text-align: left;
						order: 2;
					}
					.news_text {
						padding: 0 10px 0 0;
						margin: 0 0 10px;
						overflow: hidden;
						display: block;
						font-size: 14px;
						line-height: 24px;
						height: 48px;
						order: 3;
					}
					.news_time {
						color: #555;
						font-weight: 500;
						display: block;
						width: 100%;
						text-align: left;
						order: 4;
					}
				}
			}
		}
		// list
		// animation
		.animation_box {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box:hover {
			transform: rotate(0deg) scale(0.96) skew(0deg, 0deg) translate3d(0px, -10px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		.animation_box img {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box img:hover {
			transform: rotate(0deg) scale(1.1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		// animation
		// 更多
		.news_more_view {
			cursor: pointer;
			border: 0px solid #ddd;
			border-radius: 0px;
			padding: 0px 0;
			margin: 20px auto;
			top: 26px;
			background: none;
			width: auto;
			line-height: 34px;
			position: absolute;
			right: 7%;
			text-align: center;
			.news_more_text {
				color: #666;
				display: inline-block;
				font-size: 16px;
			}
			.el-icon {
				color: #666;
				display: inline-block;
			}
		}
	}
	// 新闻资讯
	// 首页展示
	.homeList_view {
		padding: 60px 7%;
		margin: 0px 0 0;
		background: #eee;
		width: 100%;
		position: relative;
		text-align: center;
		order: 0;

		.homeList_title {
			padding: 0px;
			margin: 0;
			color: #033561;
			background: none;
			font-weight: 500;
			width: 100%;
			font-size: 30px;
			border-color: #eee;
			border-width: 0px;
			border-style: solid;
			text-align: left;
		}
		// list
		.home_list_one {
			padding: 0;
			margin: 20px auto 0;
			color: #222;
			display: flex;
			width: 100%;
			font-size: 16px;
			align-items: flex-start;
			flex-wrap: wrap;
			.home_item1 {
				cursor: pointer;
				border: 0px solid #ddd;
				padding: 0;
				margin: 0 30px 30px 0;
				width: calc(34% - 30px);
				position: relative;
				.home_img_box {
					margin: 0 0 0px;
					width: 100%;
					.home_img {
						object-fit: cover;
						width: 100%;
						height: 320px;
					}
				}
				.home_content {
					border: 1px solid #ddd;
					padding: 20px;
					background: #fff;
					width: 100%;
					line-height: 30px;
					text-align: center;
					.home_title {
						color: inherit;
						font-size: inherit;
					}
				}
			}
			.home_item2 {
				margin: 0 0 30px;
				width: 66%;
				.item2_top {
					cursor: pointer;
					border: 0px solid #ddd;
					padding: 0;
					margin: 0px;
					width: calc(50% - 20px);
					position: relative;
					float: left;
					.home_img_box {
						margin: 0 0 0px;
						width: 100%;
						.home_img {
							object-fit: cover;
							width: 100%;
							height: 320px;
						}
					}
					.home_content {
						border: 1px solid #ddd;
						padding: 20px;
						background: #fff;
						width: 100%;
						line-height: 30px;
						text-align: center;
						.home_title {
							color: inherit;
							font-size: inherit;
						}
					}
				}
				.item2_bottom {
					cursor: pointer;
					border: 0px solid #ddd;
					padding: 0;
					width: calc(50% - 10px);
					position: relative;
					float: right;
					.home_img_box {
						margin: 0 0 0px;
						width: 100%;
						.home_img {
							object-fit: cover;
							width: 100%;
							height: 320px;
						}
					}
					.home_content {
						border: 1px solid #ddd;
						padding: 20px;
						background: #fff;
						width: 100%;
						line-height: 30px;
						text-align: center;
						.home_title {
							color: inherit;
							font-size: inherit;
						}
					}
				}
			}
			.home_item3 {
				cursor: pointer;
				border: 0px solid #ddd;
				padding: 0;
				margin: 0 30px 0 0;
				display: block;
				width: calc(34% - 30px);
				position: relative;
				.home_img_box {
					width: 100%;
					.home_img {
						object-fit: cover;
						width: 100%;
						height: 320px;
					}
				}
				.home_content {
					border: 1px solid #ddd;
					padding: 20px;
					background: #fff;
					width: 100%;
					line-height: 30px;
					text-align: center;
					.home_title {
						color: inherit;
						font-size: inherit;
					}
				}
			}
			.home_item4 {
				margin: 0 0 0 0;
				display: block;
				width: 66%;
				.item4_top {
					cursor: pointer;
					border: 0px solid #ddd;
					padding: 0;
					margin: 0;
					width: calc(50% - 20px);
					position: relative;
					float: left;
					.home_img_box {
						width: 100%;
						.home_img {
							object-fit: cover;
							width: 100%;
							height: 320px;
						}
					}
					.home_content {
						border: 1px solid #ddd;
						padding: 20px;
						background: #fff;
						width: 100%;
						line-height: 30px;
						text-align: center;
						.home_title {
							color: inherit;
							font-size: inherit;
						}
					}
				}
				.item4_bottom {
					cursor: pointer;
					border: 0px solid #ddd;
					padding: 0;
					width: calc(50% - 10px);
					position: relative;
					float: right;
					.home_img_box {
						width: 100%;
						.home_img {
							object-fit: cover;
							width: 100%;
							height: 320px;
						}
					}
					.home_content {
						border: 1px solid #ddd;
						padding: 20px;
						background: #fff;
						width: 100%;
						line-height: 30px;
						text-align: center;
						.home_title {
							color: inherit;
							font-size: inherit;
						}
					}
				}
			}
		}
		// list
		// animation
		.animation_box {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box:hover {
			transform: rotate(3deg) scale(0.96) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		.animation_box img {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box img:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		// animation
		// 更多
		.homeList_more_view {
			cursor: pointer;
			padding: 0;
			margin: 0 auto;
			top: 70px;
			background: none;
			display: inline-block;
			width: auto;
			position: absolute;
			right: 7%;
			text-align: center;
			.homeList_more_text {
				padding: 0px;
				color: #666;
				display: inline-block;
				font-size: 16px;
			}
			.el-icon {
				color: #666;
				display: inline-block;
			}
		}
	}
	// 首页展示
</style>