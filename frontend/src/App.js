import React, {useState} from "react";
import {
    Switch,
    Route, useHistory
} from "react-router-dom";
import {Box} from "@mui/material";
import TopAppBar from "./components/TopAppBar";
import useGeckoCoins from "./hooks/useGeckoCoins";
import useWalletBalances from "./hooks/useWalletBalances"
import LowerButtonNavBar from "./components/LowerButtonNavBar";
import CoingeckoOverview from "./components/CoingeckoOverview";
import WalletOverview from "./components/WalletOverview";
import Loginpage from "./pages/Loginpage";
import axios from "axios";


export default function App() {

    const [token, setToken] = useState()

    const {wallet} = useWalletBalances(token)
    const {coins} = useGeckoCoins()
    const history = useHistory();

    const login = (credentials) => {
        axios.post("/auth/login", credentials)
            .then(res => res.data)
            .then(setToken)
            .then( () => history.push("/wallet"))
            .catch(error => console.error(error.message))
    }

    return (

        <div>

            <TopAppBar/>

            <Box sx={{width: '100%', mt: 8}}>
                <Switch>

                    <Route exact path="/">
                        <CoingeckoOverview coins={coins}/>

                    </Route>

                    <Route path="/wallet">
                        <WalletOverview wallet={wallet}/>

                    </Route>

                    <Route path="/login">
                        <Loginpage login={login}/>
                    </Route>

                </Switch>
            </Box>

            <LowerButtonNavBar/>

        </div>


    );
}
