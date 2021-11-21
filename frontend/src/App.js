import {Switch, Route} from "react-router-dom";
import {Box} from "@mui/material";
import TopAppBar from "./components/TopAppBar";
import useGeckoCoins from "./hooks/useGeckoCoins";
import useWalletBalances from "./hooks/useWalletBalances"
import BottomNavBar from "./components/BottomNavBar";
import CoingeckoOverview from "./components/CoingeckoOverview";
import WalletOverview from "./components/WalletOverview";
import Loginpage from "./pages/Loginpage";
import PrivateRoute from "./routing/PrivateRoute";


export default function App() {


    const {wallet} = useWalletBalances()
    const {coins} = useGeckoCoins()



    return (

        <div>
            <TopAppBar/>

            <Box sx={{width: '100%', mt: 8}}>
                <Switch>

                    <Route exact path="/">
                        <CoingeckoOverview coins={coins}/>
                    </Route>

                    <PrivateRoute path="/wallet">
                        <WalletOverview wallet={wallet}/>
                    </PrivateRoute>

                    <Route path="/login">
                        <Loginpage/>
                    </Route>

                </Switch>
            </Box>

            <BottomNavBar/>
        </div>


    );
}
