<template>
  <el-dialog title="添加账号" :visible.sync="dialogFormVisible" v-dialogDrag width="25%">
    <el-form :model="form">
      <el-form-item label="用户名" :label-width="formLabelWidth">
        <el-input v-model="form.username" autocomplete="off" class="formItem" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item label="密码" :label-width="formLabelWidth">
        <el-input v-model="form.password" autocomplete="off" class="formItem" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item label="昵称" :label-width="formLabelWidth">
        <el-input v-model="form.nickname" autocomplete="off" class="formItem" placeholder="请输入昵称"></el-input>
      </el-form-item>
      <!-- <el-form-item label="性别" :label-width="formLabelWidth">
        <el-radio-group v-model="form.sex" class="formItem" style="width: auto; margin-top: 13px">
          <el-radio label="男">男</el-radio>
          <el-radio label="女">女</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="地址" :label-width="formLabelWidth">
        <el-cascader
          placeholder="请选择地址"
          v-model="form.addr"
          :options="options"
          class="formItem"      
          filterable>
        </el-cascader>
      </el-form-item>
      <el-form-item label="email" :label-width="formLabelWidth">
        <el-input v-model="form.email" autocomplete="off" class="formItem" placeholder="请输入邮箱"></el-input>
      </el-form-item>
      <el-form-item label="创建时间" :label-width="formLabelWidth">
        <el-date-picker
          v-model="form.buildtime"
          type="date"
          placeholder="选择日期"
          class="formItem">
        </el-date-picker>
      </el-form-item> -->
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button size="medium" @click="dialogFormVisible = false" >取 消</el-button>
      <el-button size="medium" type="primary" @click="addAdmin">添加</el-button>
    </div>
  </el-dialog>
</template>

<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
import service from '@/service/index'
import * as api from '@/api'

interface Add {
  form: Object
  formLabelWidth: String
  dialogFormVisible: Boolean
}

@Component
export default class AddAdmin extends Vue implements Add{
  @Prop() private visible!: Boolean

  form = {
    username: '',
    password: '',
    nickname: ''
  }
  formLabelWidth = '120px'
  dialogFormVisible = this.visible

  options = [{
    value: '北京',
    label: '北京',
    children: [{
      value: '朝阳区',
      label: '朝阳区',
    }, {
      value: '海淀区',
      label: '海淀区',
    }, {
      value: '东城区',
      label: '东城区',
    }, {
      value: '西城区',
      label: '西城区',
    }, {
      value: '其他',
      label: '其他',
    }]
  }, {
    value: '其他地区',
    label: '其他地区',
  }]

  @Watch('visible')
  onVisibleChange(val: Boolean, oldVal: Boolean) {
    this.dialogFormVisible = val
    for (let key in this.form) {
      this.form[key] = ''
    }
  }

  @Watch('dialogFormVisible')
  onDialogFormVisibleChange(val: Boolean, oldVal: Boolean) {
    if (!val) {
      this.$emit('getChildData', val)
    }
  }

  public addAdmin() {
    // console.log(this.form)
    api.AddUser(this.form).then((res) => {
      console.log(res)
      this.dialogFormVisible = false
      this.$message({
        message: res.message,
        type: res.result
      })
      this.$emit('getAdmin')
    })
    // service.postAdminList(this.form).then(res => {
    //   this.dialogFormVisible = false
    //   let { code, msg } = res.data
    //   if (code == 0) {
    //     this.$message({
    //       message: msg,
    //       type: 'success'
    //     })
    //   }
    //   this.$emit('getAdmin')
    // })
  }
}
</script>

<style lang="less" scoped>
.formItem {
  width: 200px;
  float: left;
}
</style>