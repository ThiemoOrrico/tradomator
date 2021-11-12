import React from "react";
import {
    Switch,
    Route
} from "react-router-dom";
import {Box} from "@mui/material";
import TopAppBar from "./components/TopAppBar";
import useGeckoCoins from "./hooks/useGeckoCoins";
import LowerButtonNavBar from "./components/LowerButtonNavBar";
import CoingeckoOverview from "./components/CoingeckoOverview";


export default function App() {

   const {coins} = useGeckoCoins()

    return (

            <div>

                <TopAppBar/>

                <Box sx={{ width: '100%' , maxHeight: 8/10}}>
                    <Switch>
                    <Route exact path="/" >
                        <CoingeckoOverview coins={coins} />

                    </Route>

                    <Route path="/Wallet">
                        <wallet />
                    </Route>

                    <Route path="/Login">
                        <login />
                    </Route>
                </Switch>
                </Box>

                <LowerButtonNavBar/>

            </div>


    );
}
