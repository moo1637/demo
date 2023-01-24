<template>
  <div>
    <h1>ItemList Page category : {{ category }} !!</h1>
    <v-card class="mx-auto" max-width="1327">
      <v-container fluid>
        <v-row dense>
          <v-col v-for="item in items" :key="item.id">
            <v-card
              heigth="200px"
              class="align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              cover
            >
              <v-card-title class="text-gray" v-text="item.name"></v-card-title>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  size="small"
                  color="surface-variant"
                  variant="text"
                  icon="mdi-cart-arrow-down"
                ></v-btn>

                <v-btn
                  size="small"
                  color="surface-variant"
                  variant="text"
                  icon="mdi-heart"
                ></v-btn>

                <v-btn
                  size="small"
                  color="surface-variant"
                  variant="text"
                  icon="mdi-bookmark"
                ></v-btn>

                <v-btn
                  size="small"
                  color="surface-variant"
                  variant="text"
                  icon="mdi-share-variant"
                ></v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-card>
  </div>
</template>
<script>
export default {
  name: 'itemList',
  props: {
    category: { type: String, default: 'menu1' }
  },
  data() {
    return {
      categoryId: '',
      items: []
    }
  },
  watch: {
    category(category) {
      console.log('category', category)
      this.categoryId = category
      this.getProductList()
    }
  },
  setup() {
    console.log('setup')
  },
  created() {
    console.log('created')
  },
  mounted() {
    this.getProductList()
    console.log('mounted')
  },
  unmounted() {
    console.log('unmounted')
  },
  methods: {
    getProductList() {
      console.log('getProductList')
      fetch('/shop/getProductList', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ categoryId: this.categoryId })
      })
        .then((response) => response.json())
        .then((data) => {
          console.log('data', data)
          this.items = data
        })
    }
  }
}
</script>
