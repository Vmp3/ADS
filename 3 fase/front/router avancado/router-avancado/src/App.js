import './App.css';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import Home from './Components/Pages/Home';
import Produtos from './Components/Pages/Produtos';
import RootLayout from './Components/Pages/RootLayout';
import { Children } from 'react';
import MainHeader from './Components/MainHeader';

function App() {
  const myRouter = createBrowserRouter([
    {
      path: '/', element: <RootLayout/>,  children: [ 
      {path: '/', element: <Home/>},
      {path: '/produtos', element: <Produtos/>}
    ]
  }
    
  ]);
  return (
    <RouterProvider router={myRouter}/>
  );
}

export default App;
