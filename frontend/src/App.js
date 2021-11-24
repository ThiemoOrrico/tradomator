import {Switch, Route} from "react-router-dom";
import {Box} from "@mui/material";
import TopAppBar from "./components/TopAppBar";
import BottomNavBar from "./components/BottomNavBar";
import Loginpage from "./pages/Loginpage";
import PrivateRoute from "./routing/PrivateRoute";
import Homepage from "./pages/Homepage";
import Walletpage from "./pages/Walletpage";
import theme from "./styling/theme";
import {ThemeProvider} from "@emotion/react";
import {CssBaseline} from "@material-ui/core";


export default function App() {
    return (
        <ThemeProvider theme={theme}>
            <div>
                <CssBaseline/>
                <TopAppBar/>

                <Box sx={{
                    width: '100%',
                    mt: 8
                }}
                >
                    <Switch>
                        <Route exact path="/">
                            <Homepage/>
                        </Route>

                        <Route exact path="/home">
                            <Homepage/>
                        </Route>

                        <PrivateRoute path="/wallet">
                            <Walletpage/>
                        </PrivateRoute>

                        <Route path="/login">
                            <Loginpage/>
                        </Route>
                    </Switch>
                </Box>
                <BottomNavBar/>
            </div>
        </ThemeProvider>
    );
}
