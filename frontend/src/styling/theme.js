import {createTheme} from "@mui/material";

const theme = createTheme({
  palette: {
    type: 'dark',

    primary: {
      main: '#566185',

      contrastText: '#ffffff',
    },

    background: {
      default: '#2c4470',
      paper: '#566185',
    },

    text: {
      primary: '#ffffff',
      secondary: 'rgba(255,255,255,0.7)',
      disabled: 'rgba(255,255,255,0.5)',
      hint: 'rgba(255,255,255,0.5)',
    },

  }

});

export default theme;
