import DisplayAMap from "@/view/displayAMap";
import HelloWorld from "@/components/HelloWorld";

const routers = [
    {
        path:'/displayAMap',
        name:'displayAMap',
        component:DisplayAMap
    },
    {
        path: '/',
        component: HelloWorld
    }
]
export default routers
