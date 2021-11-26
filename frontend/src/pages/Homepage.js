import CoingeckoOverview from "../components/CoingeckoOverview";
import useGeckoCoins from "../hooks/useGeckoCoins";

export default function Homepage(){
    const {coins} = useGeckoCoins()
    return (
            <CoingeckoOverview coins={coins}/>
    )
}