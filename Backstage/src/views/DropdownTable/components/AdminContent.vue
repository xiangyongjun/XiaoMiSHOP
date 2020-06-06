<template>
  <div class="content">
    <el-table
    :data="tableData"
    highlight-current-row
    :header-cell-style="{background:'rgba(255,218,185,0.4)',color:'#2F4F4F'}"
    @sort-change='sortChange'
    v-loading="listLoading"
    border>
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="ID">
              <span>{{ props.row.id }}</span>
            </el-form-item>
            <el-form-item label="顶栏id">
              <span>{{ props.row.sid }}</span>
            </el-form-item>
            <el-form-item label="商品id">
              <span>{{ props.row.gid }}</span>
            </el-form-item>
            <!-- <el-form-item label="图像">
              <span><img :src="props.row.image" title="图像示例"></span>
            </el-form-item> -->
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        label="ID"
        prop="id"
        align="center"
        min-width="150"
        sortable='custom'>
      </el-table-column>
      <el-table-column
        label="顶栏id"
        prop="sid"
        align="center"
        min-width="150">
      </el-table-column>
      <el-table-column
        label="商品id"
        prop="gid"
        align="center"
        min-width="150">
      </el-table-column>
      <el-table-column
        label="创建时间"
        prop="create_time"
        align="center"
        min-width="200">
      </el-table-column>
      <el-table-column
        label="更新时间"
        prop="update_time"
        align="center"
        min-width="200">
      </el-table-column>
      <el-table-column label="操作" width="200">
        <template slot-scope="scope">
          <el-button type="info" size="mini" @click="handleEdit(scope.$index, scope.row)" icon="el-icon-edit">编辑</el-button>
          <el-button type="danger" size="mini" @click="handleDel(scope.$index, scope.row)" icon="el-icon-delete">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <edit-admin :editVisible="editVisible" :row="row" @getChildData='getChildData' @flushList='flushList'></edit-admin>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'
import EditAdmin from './EditAdmin/EditAdmin.vue'
import service from '@/service/index'
import * as api from '@/api'

@Component({
  components: { EditAdmin }
})
export default class AdminContent extends Vue{
  @Prop() private tableData!: Array<object>
  @Prop() private listLoading!: Boolean

  editVisible = false
  row = {}

  public sortChange(column) {
    let { prop, order } = column
    if (order === 'descending') {
      this.tableData.sort((a, b) => b["id"] - a["id"])
    } else {
      this.tableData.sort((a, b) => a["id"] - b["id"])
    }
  }

  public getChildData(val) {
    this.editVisible = val
  }

  public handleEdit(index, row) {
    this.editVisible = true
    this.row = row
  }

  public handleDel(index, row) {
    let params = {id: row.id}
    api.DeleteDropdown(row.id).then((res) => {
      this.$message({
        message: res.message,
        type: res.result
      })
      this.$emit('contentFlush')
    })
    // service.deleteAdminList(params).then(res => {
    //   let { code, msg } = res.data
    //   this.$message({
    //     message: msg,
    //     type: 'success'
    //   })
    //   this.$emit('contentFlush')
    // })
  }

  public flushList() {
    this.$emit('contentFlush')
  }
}
</script>

<style lang="less" scoped>
.content {
  flex: 1 0 auto;
  border: 1px solid rgba(	176,196,222, 1);
  width: 100%;
  margin: 20px 0;
  overflow: auto;    
}

.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}

.el-table {
  width: 100%;
  text-align: center
}
</style>