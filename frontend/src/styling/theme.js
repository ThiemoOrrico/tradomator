import {createTheme} from "@mui/material";

const theme = createTheme({
  palette: {
    type: 'dark',

    primary: {
      main: '#596081',
      light: '#8a8e9f',
      dark: '#c9be84',
      contrastText: '#ffffff',
    },

    background: {
      default: '#232c42',
      paper: '#2e3a52',
    },

    text: {
      primary: '#ffffff',
      secondary: 'rgba(255,255,255,0.7)',
      disabled: 'rgba(255,255,255,0.5)',
      hint: 'rgba(255,255,255,0.5)',
    },

  },

  components: {
    MuiDiv: {
      styleOverrides: {
        root: {
          backgroundColor: "green"
        }
      }
    }
  },

  overrides: {
    MuiAppBar: {
      colorInherit: {
        backgroundColor: '#efefef',
        color: '#fff',
      },
    },
  },
  props: {
    MuiAppBar: {
      color: 'inherit',
    },
  },

});

export default theme;
