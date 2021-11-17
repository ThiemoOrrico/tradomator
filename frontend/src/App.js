import React from "react";
import {
    Switch,
    Route
} from "react-router-dom";
import {Box} from "@mui/material";
import TopAppBar from "./components/TopAppBar";
import useGeckoCoins from "./hooks/useGeckoCoins";
import useWalletBalances from "./hooks/useWalletBalances"
import LowerButtonNavBar from "./components/LowerButtonNavBar";
import CoingeckoOverview from "./components/CoingeckoOverview";
import WalletOverview from "./components/WalletOverview";


export default function App() {

    const {wallet} = useWalletBalances()
   const {coins} = useGeckoCoins()


    return (

            <div>

                <TopAppBar/>

                <Box sx={{ width: '100%', mt: 8}}>
                    <Switch>
                    <Route exact path="/" >
                        <CoingeckoOverview coins={coins} />

                    </Route>

                    <Route path="/wallet">
                        <p>Platzhalter für Wallet</p>


                        <WalletOverview wallet={wallet}/>

                    </Route>

                    <Route path="/login">
                        <login />
                    </Route>
                </Switch>
                </Box>

                <LowerButtonNavBar/>

            </div>


    );
}
