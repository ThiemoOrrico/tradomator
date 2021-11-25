import {createTheme} from "@mui/material";

const themeLogin = createTheme({

    palette: {
        type: 'dark',
        primary: {
            main: '#3f51b5',
            background: {
                paper: '#751414',
                default: '#a83333'

            }
        },
        secondary: {
            main: '#f50057',
        },
    },
});

export default themeLogin;