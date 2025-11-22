<template>
  <div>
    <div style="margin-right: 15px;display: flex;justify-content: space-between">
      <div style="display: flex;align-items: flex-end">
        <h2 style="margin-left: 10px;font-family:'Microsoft YaHei',Arial,sans-serif">角色信息</h2>
        <span style="margin-left: 6px">软件所有用户详细信息</span>
      </div>
    </div>
    <div style="width: 400px">
      <Divider style="margin: 0;"/>
    </div>
    <div style="margin: 10px 0 20px 20px;color: grey;font-size: 13px">
      1.价格活动是有单独页面的,需要单独进行处理<br/>
      2.价格活动上架以后需要手动去修改价格
    </div>

    <div style="margin-bottom: 10px;display: flex;justify-content: space-between">
      <ButtonGroup>
        <Button :type="findAllParan.status===1?'primary':'default'" @click="changeButtonType(1)">
          正常
        </Button>
        <Button :type="findAllParan.status===2?'primary':'default'" @click="changeButtonType(2)">
          注销
        </Button>
      </ButtonGroup>
      <div>
        <!--        <Button type="primary" @click="actionDetailModal=true" style="margin-right: 15px">定制新的运营活动</Button>-->
        <Button @click="findAll" type="primary">
          <Icon type="md-refresh"/>
          刷新
        </Button>
      </div>
    </div>

    <!-- 运营数据-->
    <Table border :columns="columns" :data="salesList">
      <template slot-scope="{ row }" slot="name">
        <strong>{{ row.name }}</strong>
      </template>
      <template slot-scope="{ row, index }" slot="action">
        <Button type="primary" size="small" style="margin-right: 5px" @click="showInfo(row.id)">更多信息</Button>
      </template>
    </Table>
    <div style="display: flex;justify-content: space-between;margin-top: 10px">
      <Page :total="salesCount" show-sizer show-elevator show-total :current.sync="findAllParan.currentPage"
            @on-page-size-change="pageChange" @on-change="findAll"/>
    </div>

    <!-- 活动详情 -->
    <Modal width="50" ok-text="确定"
           v-model="actionDetailModal"
           title="用户详情" style="user-select: none;"
           @on-ok="modalOk" @on-cancel="reset">
      <Form :label-width="200">
        <FormItem v-if="detail.id" label="名称" style="margin: 0">
          <span style="color: grey; margin-right: 30px">{{detail.name}}</span>
        </FormItem>
        <FormItem label="账户状态"
                  style="margin:2px 0;">
          <RadioGroup v-model="detail.enable">
            <Radio :label="1">正常</Radio>
            <Radio :label="2">注销</Radio>
          </RadioGroup>
        </FormItem>
        <FormItem label="创建时间"
                  style="margin:2px 0;">
          <span>{{detail.createTime}}</span>
        </FormItem>
        <FormItem label="备注"
                  style="margin:2px 0;">
          <span>{{detail.remark}}</span>
        </FormItem>
      </Form>
    </Modal>
  </div>
</template>

<script>
  import {roleGetAll, roleDetail, roleUpdate} from '@/api/user'

  export default {
    data() {
      return {
        priceAction: false,
        hasChange: false,
        columns: [
          {
            title: 'ID',
            key: 'id',
            width: 70,
          }, {
            title: '创建时间',
            key: 'createTime',
          }, {
            title: '状态',
            key: 'enable',
          }, {
            title: '名称',
            key: 'name',
          }, {
            title: '备注',
            key: 'remark',
          }, {
            title: '操作',
            slot: 'action',
            width: 120,
            align: 'center'
          }
        ],
        actionDetailModal: false,
        salesList: [],
        salesCount: 0,
        findAllParan: {
          currentPage: 1,
          pageSize: 10,
        },
        detail: {}
      }
    },
    created() {
      this.findAll();
    },
    methods: {

      // 查看详情
      showInfo(id) {
        this.actionDetailModal = true;
        this.findDetail(id)
      },

      // 点击确定
      modalOk() {
        roleUpdate(this.detail).then(res => {
          if (res.status === 200 && res.data.status === true) {
            this.$Notice.info({title: res.data.data.msg});
          } else {
            this.$Notice.error({title: "用户信息修改失败!"});
          }

          this.findAll();
        })
        this.actionDetailModal = false;
        this.reset()
      },

      // 分类查询
      changeButtonType(type) {
        this.findAllParan = {
          currentPage: 1,
          pageSize: 10,
        };
        this.findAllParan.status = type;
        this.findAll();
      },

      // 查看详情
      findDetail(id) {
        roleDetail(id).then(res => {
          if (res.data.status === true) {
            this.detail = res.data.data
          }
        })
      },

      // 查看所有
      findAll() {
        roleGetAll(this.findAllParan).then(res => {
          if (res.data.status === true) {
            this.salesList = res.data.data
            this.salesCount = res.data.total

            // 修改数据
            this.salesList.forEach(i => {
              switch (i.enable) {
                case 0:  i.enable = 'error'; break;
                case 1:  i.enable = '正常'; break;
                case 2:  i.enable = '不可用'; break;
              }
            })
          }
        })
      },

      // 分页查询
      pageChange(res) {
        this.findAllParan.pageSize = res
        this.findAll()
      },

      // 数据复原
      reset() {
        this.detail = {}
      }
    }
  }
</script>

<style lang="less">
</style>
