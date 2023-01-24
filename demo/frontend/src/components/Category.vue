<template>
  <v-app>
    <v-app-bar :elevation="1">
      <v-app-bar-title
        style="text-align: center; cursor: pointer"
        @click="this.$router.push('/')"
        >yskimdev frontend study site</v-app-bar-title
      >
    </v-app-bar>
    <v-app-bar :elevation="1">
      <v-app-bar-nav-icon
        variant="text"
        @click.stop="drawer = !drawer"
      ></v-app-bar-nav-icon
      ><v-app-bar-title>{{ categoryTitle }}</v-app-bar-title>

      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon>mdi-cart</v-icon>
      </v-btn>
      <v-btn icon>
        <v-icon>mdi-account</v-icon>
      </v-btn>
      <v-btn icon>
        <v-icon>mdi-logout</v-icon>
      </v-btn>
    </v-app-bar>
    <!-- <v-main @mouseover=";(secondDrawer = false), (thirdDrawer = false)"> -->
    <v-main>
      <router-view />
    </v-main>
    <v-navigation-drawer v-model="drawer">
      <v-list v-model:opened="open" v-model:selected="category">
        <template v-for="firstDepth in drawerItems" :key="firstDepth.id">
          <!-- 자식 노드가 존재할 경우 -->
          <template v-if="firstDepth.children">
            <v-list-group :value="firstDepth.id">
              <template v-slot:activator="{ props }">
                <v-list-item
                  v-bind="props"
                  :title="firstDepth.name"
                  @click.capture.stop="moveItemList($event, firstDepth.id)"
                ></v-list-item>
              </template>
              <template
                v-for="secondDepth in firstDepth.children"
                :key="secondDepth.id"
              >
                <!-- 3번째 노드가 존재할 경우 -->
                <template v-if="secondDepth.children">
                  <v-list-group :value="secondDepth.id">
                    <template v-slot:activator="{ props }">
                      <v-list-item
                        v-bind="props"
                        :title="secondDepth.name"
                        :value="secondDepth.id"
                        @click.capture.stop="
                          moveItemList($event, secondDepth.id)
                        "
                      ></v-list-item>
                    </template>
                    <v-list-item
                      v-for="thirdDepth in secondDepth.children"
                      :key="thirdDepth.id"
                      :title="thirdDepth.name"
                      @click.capture.stop="moveItemList($event, thirdDepth.id)"
                    >
                    </v-list-item>
                  </v-list-group>
                </template>
                <!-- 2번째 노드가 마지막일 경우 -->
                <template v-else>
                  <v-list-item
                    :title="secondDepth.name"
                    @click.capture.stop="moveItemList($event, secondDepth.id)"
                  ></v-list-item>
                </template>
              </template>
            </v-list-group>
          </template>
          <!-- 최상위 1개만 있을 경우-->
          <template v-else>
            <v-list-item
              :title="firstDepth.name"
              @click.capture.stop="moveItemList($event, firstDepth.id)"
            ></v-list-item
          ></template>
        </template>
      </v-list>
    </v-navigation-drawer>
  </v-app>
</template>
<script>
export default {
  name: 'categoryView',
  components: {},
  data() {
    return {
      open: [],
      category: [],
      categoryTitle: 'shop',
      drawer: true,
      drawerItems: []
    }
  },
  watch: {
    open() {
      console.log('open', this.open)
    },
    category() {
      console.log(',category', this.category)
    }
  },
  setup() {},
  created() {},
  mounted() {
    fetch('/shop/getCategoryList')
      .then((response) => response.json())
      .then((data) => {
        this.drawerItems = data
          .filter((record) => record.parentId === null)
          .map((record) => {
            const tmpList = data.filter(
              (dRecord) => dRecord.parentId === record.id
            )
            if (tmpList.length > 0) {
              record.children = tmpList

              record.children.map((cRecord) => {
                const tmpList = data.filter(
                  (dRecord) => dRecord.parentId === cRecord.id
                )
                if (tmpList.length > 0) {
                  cRecord.children = tmpList
                }
                return cRecord
              })
            }
            return record
          })
      })
      .catch((error) => console.error(error))
  },
  unmounted() {},
  methods: {
    moveItemList(event, category) {
      console.log('moveItemList')
      if (event.target.className === 'v-list-item-title') {
        this.$router.push({
          name: 'itemList',
          params: { category: category }
        })
      } else {
        const idx = this.open.indexOf(category)
        idx > -1 ? this.open.splice(idx, 1) : this.open.push(category)
      }
    },
    fnClickOnce(e) {
      console.log('fnClickOnce', e)
    },
    fnClick(e) {
      console.log('fnClick', e)
      console.log('target', e.target.modelValue)
    }
  }
}
</script>
<style scope>
.v-list-item {
  min-height: 30px !important;
  height: 30px !important;
}

/* .v-list-item > .v-btn {
  min-height: 20px !important;
  height: 20px !important;
  min-width: 20px !important;
  width: 20px !important;
} */

.c_2 {
  margin-left: 5px;
  background-color: blue;
}
.c_3 {
  margin-left: 10px;
  background-color: blueviolet;
}
</style>
