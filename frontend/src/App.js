import {Switch, Route} from "react-router-dom";
import {Box} from "@mui/material";
import TopAppBar from "./components/TopAppBar";
import BottomNavBar from "./components/BottomNavBar";
import Loginpage from "./pages/Loginpage";
import PrivateRoute from "./routing/PrivateRoute";
import Homepage from "./pages/Homepage";
import Walletpage from "./pages/Walletpage";
import {CssBaseline} from "@material-ui/core";
import styled from "styled-components/macro";


export default function App() {
    return (
            <PageLayout >
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
            </PageLayout>
    );
}
const PageLayout = styled.div`
  background-color: #2c4470;
`
