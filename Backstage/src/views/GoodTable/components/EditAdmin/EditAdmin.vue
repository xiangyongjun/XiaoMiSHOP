<template>
  <el-dialog title="编辑商品" :visible.sync="dialogFormVisible" v-dialogDrag width="25%">
    <el-form :model="form">
      <el-form-item label="商品ID" :label-width="formLabelWidth">
        <el-input v-model="form.id" autocomplete="off" class="formItem" placeholder="请输入轮播图id" disabled></el-input>
      </el-form-item>
      <el-form-item label="标题" :label-width="formLabelWidth">
        <el-input v-model="form.title" autocomplete="off" class="formItem" placeholder="请输入图片地址"></el-input>
      </el-form-item>
      <el-form-item label="图片地址" :label-width="formLabelWidth">
        <el-input v-model="form.src" autocomplete="off" class="formItem" placeholder="请输入图片地址"></el-input>
      </el-form-item>
      <el-form-item label="介绍" :label-width="formLabelWidth">
        <el-input v-model="form.desc" autocomplete="off" class="formItem" placeholder="请输入介绍"></el-input>
      </el-form-item>
      <el-form-item label="价格" :label-width="formLabelWidth">
        <el-input v-model="form.price" autocomplete="off" class="formItem" placeholder="请输入价格"></el-input>
      </el-form-item>
      <el-form-item label="原价格" :label-width="formLabelWidth">
        <el-input v-model="form.old_price" autocomplete="off" class="formItem" placeholder="请输入原价格"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button size="medium" @click="dialogFormVisible = false" >取 消</el-button>
      <el-button size="medium" type="primary" @click="editAdmin" :loading="loading">编辑</el-button>
    </div>
  </el-dialog>
</template>

<script lang="ts">
import { Component, Prop, Vue, Watch } from 'vue-property-decorator'
import service from '@/service/index'
import * as api from '@/api'

interface Edit {
  form: Object
  formLabelWidth: String
  dialogFormVisible: Boolean
  loading: Boolean
}

@Component
export default class AddAdmin extends Vue implements Edit{
  @Prop() private editVisible!: Boolean
  @Prop() private row !: Object

  form = this.row
  formLabelWidth = '120px'
  dialogFormVisible = this.editVisible
  loading = false

  @Watch('editVisible')
  onVisibleChange(val: Boolean, oldVal: Boolean) {
    this.dialogFormVisible = val
  }

  @Watch('dialogFormVisible')
  onDialogFormVisibleChange(val: Boolean, oldVal: Boolean) {
    if (!val) {
      this.$emit('getChildData', val)
    }
  }

  @Watch('row')
  onRowChange(val) {
    this.form = val
  }

  public editAdmin() {
    let params = this.form
    this.loading = true
    api.EditGood(this.form).then((res) => {
      console.log(res)
      this.dialogFormVisible = false
      this.$message({
        message: res.message,
        type: res.result
      })
      this.$emit('flushList')
    })
    // service.putAdminList(params).then(res => {
    //   this.loading = false
    //   this.dialogFormVisible = false
    //   let { code, msg } = res.data
    //   if (code == 0) {
    //     this.$message({
    //       message: msg,
    //       type: 'success'
    //     })
    //   }
    //   this.$emit('flushList')
    // }) 
  }
}
</script>

<style lang="less" scoped>
.formItem {
  width: 200px;
  float: left
}
</style>