<template>
  <div
    class="app-contain"
    :style="{
      minHeight: '100vh',
      padding: '0',
      margin: '20px auto 60px',
      borderRadius: '0px',
      background: '#fff',
      width: '86%',
      position: 'relative',
      height: '100%',
    }"
  >
    <div class="bread_view">
      <el-breadcrumb separator=">" class="breadcrumb">
        <el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }"
          >首页</el-breadcrumb-item
        >
        <el-breadcrumb-item
          class="second_breadcrumb"
          v-for="(item, index) in breadList"
          :key="index"
          >{{ item.name }}</el-breadcrumb-item
        >
      </el-breadcrumb>
    </div>
    <el-form
      ref="formRef"
      :model="form"
      class="add_form"
      label-width="120px"
      :rules="rules"
    >
      <el-row>
        <el-col :span="8">
          <el-form-item label="职位名称" prop="zhiweimingcheng">
            <el-input
              class="list_inp"
              v-model="form.zhiweimingcheng"
              placeholder="职位名称"
              type="text"
              :readonly="!isAdd || disabledForm.zhiweimingcheng ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="8">
          <el-form-item label="公司要求" prop="gongsiyaoqiu">
            <el-input
              class="list_inp"
              v-model="form.gongsiyaoqiu"
              placeholder="公司要求"
              type="text"
              :readonly="!isAdd || disabledForm.gongsiyaoqiu ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="8">
          <el-form-item label="公司要求学历" prop="gongsiyaoqiuxueli">
            <el-select
              class="list_sel"
              :disabled="
                !isAdd || disabledForm.gongsiyaoqiuxueli ? true : false
              "
              v-model="form.gongsiyaoqiuxueli"
              placeholder="请选择公司要求学历"
              style="width: 100%"
            >
              <el-option
                v-for="(item, index) in gongsiyaoqiuxueliLists"
                :label="item"
                :value="item"
              >
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="岗位专业" prop="gangweizhuanye">
            <el-input
              class="list_inp"
              v-model="form.gangweizhuanye"
              placeholder="岗位专业"
              type="text"
              :readonly="!isAdd || disabledForm.gangweizhuanye ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="8">
          <el-form-item label="薪资" prop="xinzi">
            <el-input
              class="list_inp"
              v-model="form.xinzi"
              placeholder="薪资"
              type="text"
              :readonly="!isAdd || disabledForm.xinzi ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="8">
          <el-form-item label="企业账号" prop="qiyezhanghao">
            <el-input
              class="list_inp"
              v-model="form.qiyezhanghao"
              placeholder="企业账号"
              type="text"
              :readonly="!isAdd || disabledForm.qiyezhanghao ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="8">
          <el-form-item label="企业名称" prop="qiyemingcheng">
            <el-input
              class="list_inp"
              v-model="form.qiyemingcheng"
              placeholder="企业名称"
              type="text"
              :readonly="!isAdd || disabledForm.qiyemingcheng ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="8">
          <el-form-item label="企业地址" prop="qiyedizhi">
            <el-input
              class="list_inp"
              v-model="form.qiyedizhi"
              placeholder="企业地址"
              type="text"
              :readonly="!isAdd || disabledForm.qiyedizhi ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="8">
          <el-form-item label="联系电话" prop="lianxidianhua">
            <el-input
              class="list_inp"
              v-model="form.lianxidianhua"
              placeholder="联系电话"
              type="text"
              :readonly="!isAdd || disabledForm.lianxidianhua ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="封面" prop="fengmian">
            <uploads
              :disabled="!isAdd || disabledForm.fengmian ? true : false"
              action="file/upload"
              tip="请上传封面"
              :limit="3"
              style="width: 100%; text-align: left"
              :fileUrls="form.fengmian ? form.fengmian : ''"
              @change="fengmianUploadSuccess"
            >
            </uploads>
          </el-form-item>
        </el-col>
      </el-row>
      <div class="formModel_btn_box">
        <el-button class="formModel_cancel" @click="backClick">取消</el-button>
        <el-button class="formModel_confirm" @click="save" type="success">
          保存
        </el-button>
      </div>
    </el-form>
  </div>
</template>
<script setup>
import {
  ref,
  getCurrentInstance,
  watch,
  onUnmounted,
  onMounted,
  nextTick,
  computed,
} from 'vue'
import { useRoute, useRouter } from 'vue-router'
const context = getCurrentInstance()?.appContext.config.globalProperties
const route = useRoute()
const router = useRouter()
//基础信息
const tableName = 'xiaozhaogangweifabu'
const formName = '校招岗位发布'
//基础信息
const breadList = ref([
  {
    name: formName,
  },
])
//获取唯一标识
const getUUID = () => {
  return new Date().getTime()
}
//form表单
const form = ref({
  zhiweimingcheng: '',
  gongsiyaoqiu: '',
  gongsiyaoqiuxueli: '',
  gangweizhuanye: '',
  xinzi: '',
  qiyezhanghao: '',
  qiyemingcheng: '',
  qiyedizhi: '',
  lianxidianhua: '',
  sfsh: '待审核',
  shhf: '',
  fengmian: '',
})
const formRef = ref(null)
const id = ref(0)
const type = ref('')
const disabledForm = ref({
  zhiweimingcheng: false,
  gongsiyaoqiu: false,
  gongsiyaoqiuxueli: false,
  gangweizhuanye: false,
  xinzi: false,
  qiyezhanghao: false,
  qiyemingcheng: false,
  qiyedizhi: false,
  lianxidianhua: false,
  sfsh: false,
  shhf: false,
  fengmian: false,
})
const isAdd = ref(false)
//表单验证
//匹配整数
const validateIntNumber = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.isIntNumer(value)) {
    callback(new Error('请输入整数'))
  } else {
    callback()
  }
}
//匹配数字
const validateNumber = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.isNumber(value)) {
    callback(new Error('请输入数字'))
  } else {
    callback()
  }
}
//匹配手机号码
const validateMobile = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.isMobile(value)) {
    callback(new Error('请输入正确的手机号码'))
  } else {
    callback()
  }
}
//匹配电话号码
const validatePhone = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.isPhone(value)) {
    callback(new Error('请输入正确的电话号码'))
  } else {
    callback()
  }
}
//匹配邮箱
const validateEmail = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.isEmail(value)) {
    callback(new Error('请输入正确的邮箱地址'))
  } else {
    callback()
  }
}
//匹配身份证
const validateIdCard = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.checkIdCard(value)) {
    callback(new Error('请输入正确的身份证号码'))
  } else {
    callback()
  }
}
//匹配网站地址
const validateUrl = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.isURL(value)) {
    callback(new Error('请输入正确的URL地址'))
  } else {
    callback()
  }
}
const rules = ref({
  zhiweimingcheng: [],
  gongsiyaoqiu: [],
  gongsiyaoqiuxueli: [],
  gangweizhuanye: [],
  xinzi: [],
  qiyezhanghao: [],
  qiyemingcheng: [],
  qiyedizhi: [],
  lianxidianhua: [],
  sfsh: [],
  shhf: [],
  fengmian: [],
})
//公司要求学历列表
const gongsiyaoqiuxueliLists = ref([])
//封面上传回调
const fengmianUploadSuccess = (e) => {
  form.value.fengmian = e
}
//methods

//methods
//获取info
const getInfo = () => {
  context
    ?.$http({
      url: `${tableName}/info/${id.value}`,
      method: 'get',
    })
    .then((res) => {
      let reg = new RegExp('../../../file', 'g')
      form.value = res.data.data
    })
}
const crossRow = ref('')
const crossTable = ref('')
const crossTips = ref('')
const crossColumnName = ref('')
const crossColumnValue = ref('')
//初始化
const init = (
  formId = null,
  formType = 'add',
  formNames = '',
  row = null,
  table = null,
  statusColumnName = null,
  tips = null,
  statusColumnValue = null
) => {
  if (formId) {
    id.value = formId
    type.value = formType
  }
  if (formType == 'add') {
    isAdd.value = true
  } else if (formType == 'info') {
    isAdd.value = false
    getInfo()
  } else if (formType == 'edit') {
    isAdd.value = true
    getInfo()
  } else if (formType == 'cross') {
    isAdd.value = true
    // getInfo()
    for (let x in row) {
      if (x == 'zhiweimingcheng') {
        form.value.zhiweimingcheng = row[x]
        disabledForm.value.zhiweimingcheng = true
        continue
      }
      if (x == 'gongsiyaoqiu') {
        form.value.gongsiyaoqiu = row[x]
        disabledForm.value.gongsiyaoqiu = true
        continue
      }
      if (x == 'gongsiyaoqiuxueli') {
        form.value.gongsiyaoqiuxueli = row[x]
        disabledForm.value.gongsiyaoqiuxueli = true
        continue
      }
      if (x == 'gangweizhuanye') {
        form.value.gangweizhuanye = row[x]
        disabledForm.value.gangweizhuanye = true
        continue
      }
      if (x == 'xinzi') {
        form.value.xinzi = row[x]
        disabledForm.value.xinzi = true
        continue
      }
      if (x == 'qiyezhanghao') {
        form.value.qiyezhanghao = row[x]
        disabledForm.value.qiyezhanghao = true
        continue
      }
      if (x == 'qiyemingcheng') {
        form.value.qiyemingcheng = row[x]
        disabledForm.value.qiyemingcheng = true
        continue
      }
      if (x == 'qiyedizhi') {
        form.value.qiyedizhi = row[x]
        disabledForm.value.qiyedizhi = true
        continue
      }
      if (x == 'lianxidianhua') {
        form.value.lianxidianhua = row[x]
        disabledForm.value.lianxidianhua = true
        continue
      }
      if (x == 'fengmian') {
        form.value.fengmian = row[x]
        disabledForm.value.fengmian = true
        continue
      }
    }
    if (row) {
      crossRow.value = row
    }
    if (table) {
      crossTable.value = table
    }
    if (tips) {
      crossTips.value = tips
    }
    if (statusColumnName) {
      crossColumnName.value = statusColumnName
    }
    if (statusColumnValue) {
      crossColumnValue.value = statusColumnValue
    }
    form.value.sfsh = '待审核'
  }
  context
    ?.$http({
      url: `${context?.$toolUtil.storageGet('frontSessionTable')}/session`,
      method: 'get',
    })
    .then((res) => {
      var json = res.data.data
      if (
        json.hasOwnProperty('qiyezhanghao') &&
        context?.$toolUtil.storageGet('frontRole') != '管理员'
      ) {
        form.value.qiyezhanghao = json.qiyezhanghao
        disabledForm.value.qiyezhanghao = true
      }
      if (
        json.hasOwnProperty('qiyemingcheng') &&
        context?.$toolUtil.storageGet('frontRole') != '管理员'
      ) {
        form.value.qiyemingcheng = json.qiyemingcheng
        disabledForm.value.qiyemingcheng = true
      }
      if (
        json.hasOwnProperty('qiyedizhi') &&
        context?.$toolUtil.storageGet('frontRole') != '管理员'
      ) {
        form.value.qiyedizhi = json.qiyedizhi
        disabledForm.value.qiyedizhi = true
      }
      if (
        json.hasOwnProperty('lianxidianhua') &&
        context?.$toolUtil.storageGet('frontRole') != '管理员'
      ) {
        form.value.lianxidianhua = json.lianxidianhua
        disabledForm.value.lianxidianhua = true
      }
    })
  gongsiyaoqiuxueliLists.value = '大专,本科,研究生'.split(',')
}
//初始化
//取消
const backClick = () => {
  history.back()
}
//提交
const save = () => {
  if (form.value.fengmian != null) {
    form.value.fengmian = form.value.fengmian.replace(
      new RegExp(context?.$config.url, 'g'),
      ''
    )
  }
  var table = crossTable.value
  var objcross = JSON.parse(JSON.stringify(crossRow.value))
  let crossUserId = ''
  let crossRefId = ''
  let crossOptNum = ''
  if (type.value == 'cross') {
    if (crossColumnName.value != '') {
      if (!crossColumnName.value.startsWith('[')) {
        for (let o in objcross) {
          if (o == crossColumnName.value) {
            objcross[o] = crossColumnValue.value
          }
        }
        //修改跨表数据
        changeCrossData(objcross)
      } else {
        crossUserId = context?.$toolUtil.storageGet('userid')
        crossRefId = objcross['id']
        crossOptNum = crossColumnName.value.replace(/\[/, '').replace(/\]/, '')
      }
    }
  }
  formRef.value.validate((valid) => {
    if (valid) {
      if (crossUserId && crossRefId) {
        form.value.crossuserid = crossUserId
        form.value.crossrefid = crossRefId
        let params = {
          page: 1,
          limit: 1000,
          crossuserid: form.value.crossuserid,
          crossrefid: form.value.crossrefid,
        }
        context
          ?.$http({
            url: `${tableName}/page`,
            method: 'get',
            params: params,
          })
          .then((res) => {
            if (res.data.data.total >= crossOptNum) {
              context?.$toolUtil.message(`${crossTips.value}`, 'error')
              return false
            } else {
              context
                ?.$http({
                  url: `${tableName}/${!form.value.id ? 'save' : 'update'}`,
                  method: 'post',
                  data: form.value,
                })
                .then((res) => {
                  context?.$toolUtil.message(`操作成功`, 'success', () => {
                    history.back()
                  })
                })
            }
          })
      } else {
        context
          ?.$http({
            url: `${tableName}/${!form.value.id ? 'save' : 'update'}`,
            method: 'post',
            data: form.value,
          })
          .then((res) => {
            context?.$toolUtil.message(`操作成功`, 'success', () => {
              history.back()
            })
          })
      }
    }
  })
}
//修改跨表数据
const changeCrossData = (row) => {
  context
    ?.$http({
      url: `${crossTable.value}/update`,
      method: 'post',
      data: row,
    })
    .then((res) => {})
}
onMounted(() => {
  type.value = route.query.type ? route.query.type : 'add'
  let row = null
  let table = null
  let statusColumnName = null
  let tips = null
  let statusColumnValue = null
  if (type.value == 'cross') {
    row = context?.$toolUtil.storageGet('crossObj')
      ? JSON.parse(context?.$toolUtil.storageGet('crossObj'))
      : {}
    table = context?.$toolUtil.storageGet('crossTable')
    statusColumnName = context?.$toolUtil.storageGet('crossStatusColumnName')
    tips = context?.$toolUtil.storageGet('crossTips')
    statusColumnValue = context?.$toolUtil.storageGet('crossStatusColumnValue')
  }
  init(
    route.query.id ? route.query.id : null,
    type.value,
    '',
    row,
    table,
    statusColumnName,
    tips,
    statusColumnValue
  )
})
</script>
<style lang="scss" scoped>
// 面包屑盒子
.bread_view {
  border-radius: 0px;
  padding: 12px 20px;
  margin: 0px auto;
  background: none;
  width: 100%;
  border-color: #eee;
  border-width: 0 0 0px;
  position: relative;
  border-style: solid;
  :deep(.breadcrumb) {
    font-size: 14px;
    line-height: 1;
    .el-breadcrumb__separator {
      margin: 0 9px;
      color: #999;
      font-weight: 500;
    }
    .first_breadcrumb {
      .el-breadcrumb__inner {
        color: #333;
        display: inline-block;
      }
    }
    .second_breadcrumb {
      .el-breadcrumb__inner {
        color: #999;
        display: inline-block;
      }
    }
  }
}
// 表单
.add_form {
  border: 1px solid #ddd;
  border-radius: 0px;
  padding: 40px 7% 50px;
  background: url(http://localhost:8080/collegeEmployment/file/974a5cd5eb9840c9b1a4576231567b5c.png);
  // form item
  :deep(.el-form-item) {
    border: 0px solid #eee;
    padding: 6px 0;
    margin: 0 0 20px 0;
    background: none;
    display: flex;
    //label
    .el-form-item__label {
      background: none;
      display: block;
      width: auto;
      min-width: 150px;
      text-align: right;
    }
    // 内容盒子
    .el-form-item__content {
      display: flex;
      width: calc(100% - 150px);
      justify-content: flex-start;
      align-items: center;
      flex-wrap: wrap;
      // 输入框
      .list_inp {
        padding: 0 10px;
        background: #fff;
        width: auto;
        border-color: #ccc;
        border-width: 1px;
        line-height: 36px;
        box-sizing: border-box;
        border-style: solid;
        min-width: 100%;
        height: 36px;
        //去掉默认样式
        .el-input__wrapper {
          border: none;
          box-shadow: none;
          background: none;
          border-radius: 0;
          height: 100%;
          padding: 0;
        }
        .is-focus {
          box-shadow: none !important;
        }
      }
      // 下拉框
      .list_sel {
        border-radius: 0px;
        padding: 0 10px;
        background: #fff;
        width: auto;
        border-color: #ccc;
        border-width: 1px;
        line-height: 36px;
        box-sizing: border-box;
        border-style: solid;
        min-width: 100%;
        //去掉默认样式
        .select-trigger {
          height: 100%;
          .el-input {
            height: 100%;
            .el-input__wrapper {
              border: none;
              box-shadow: none;
              background: none;
              border-radius: 0;
              height: 100%;
              padding: 0;
            }
            .is-focus {
              box-shadow: none !important;
            }
          }
        }
      }
      //图片上传样式
      .el-upload-list {
        //提示语
        .el-upload__tip {
          margin: 7px 0 0;
          color: #999;
          display: flex;
          font-size: 14px;
          justify-content: flex-start;
          align-items: center;
        }
        //外部盒子
        .el-upload--picture-card {
          border: 1px solid #ccc;
          cursor: pointer;
          border-radius: 0px;
          background: #fff;
          width: 150px;
          line-height: 90px;
          text-align: center;
          height: 80px;
          //图标
          .el-icon {
            color: #999;
            font-weight: 600;
            font-size: 24px;
          }
        }
        .el-upload-list__item {
          border: 1px solid #ccc;
          cursor: pointer;
          border-radius: 0px;
          background: #fff;
          width: 150px;
          line-height: 90px;
          text-align: center;
          height: 80px;
        }
      }
    }
  }
}
// 按钮盒子
.formModel_btn_box {
  padding: 0 150px;
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: center;
  .formModel_cancel {
    border: 1px solid #ccc;
    cursor: pointer;
    border-radius: 0px;
    padding: 0 40px;
    margin: 0 20px 0 0;
    color: #999;
    background: #f9f9f9;
    width: auto;
    font-size: 14px;
    line-height: 40px;
    transition: all 0.3s;
    height: 40px;
  }
  .formModel_cancel:hover {
    transform: rotate(0deg) scale(0.9) skew(0deg, 0deg)
      translate3d(0px, -10px, 0px);
  }

  .formModel_confirm {
    border: 0px solid #11396190;
    cursor: pointer;
    border-radius: 0px;
    padding: 0 40px;
    margin: 0 20px 0 0;
    color: #fff;
    background: #3a73ab;
    width: auto;
    font-size: 14px;
    line-height: 40px;
    transition: all 0.3s;
    height: 40px;
  }
  .formModel_confirm:hover {
    transform: rotate(0deg) scale(0.9) skew(0deg, 0deg)
      translate3d(0px, -10px, 0px);
  }
}
</style>
