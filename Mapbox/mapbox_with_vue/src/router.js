import DisplayAMap from "@/view/displayAMap";
import HelloWorld from "@/view/HelloWorld";
import addTerrain from "@/view/addTerrain";
import addModel from "@/view/addModel";

const routers = [
    {
        path:'/displayAMap',
        name:'displayAMap',
        component:DisplayAMap
    },
    {
        path:'/addTerrain',
        name:'addTerrain',
        component:addTerrain
    },{
        path:'/addModel',
        name:'addModel',
        component:addModel
    },

    {
        path: '/',
        component: HelloWorld
    }
]
export default routers
