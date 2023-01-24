// Styles
import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/styles'

// Vuetify
import { createVuetify } from 'vuetify'
import { VBtn } from 'vuetify/components'

export default createVuetify({
  display: {
    mobileBreakpoint: 'sm',
    thresholds: {
      xs: 0,
      sm: 340,
      md: 540,
      lg: 800,
      xl: 1280
    }
  },
  aliases: {
    MyButton: VBtn
  },
  defaults: {
    // MyButton: {
    //   color: 'primary',
    //   variant: 'tonal'
    // },
    // VBtn: {
    //   color: 'secondary',
    //   variant: 'flat'
    // },
    // VCard: {
    //   MyButton: { color: 'secondary' },
    //   VBtn: { color: 'primary' }
    // }
  }
})
// https://vuetifyjs.com/en/introduction/why-vuetify/#feature-guides
