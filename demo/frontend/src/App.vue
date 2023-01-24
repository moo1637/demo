<template>
  <category />
</template>

<script>
import { computed } from 'vue'
import { useDisplay } from 'vuetify'
import category from './components/Category.vue'

export default {
  name: 'App',
  components: { category },
  data: () => ({}),
  setup() {
    const { name } = useDisplay()

    const height = computed(() => {
      // name is reactive and
      // must use .value
      switch (name.value) {
        case 'xs':
          return 220
        case 'sm':
          return 400
        case 'md':
          return 500
        case 'lg':
          return 600
        case 'xl':
          return 800
        case 'xxl':
          return 1200
      }

      return undefined
    })

    return { height }
  },
  mounted() {},
  methods: {}
}
</script>
