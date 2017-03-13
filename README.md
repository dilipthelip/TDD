# TDD

This tutorial is about TDD and different frameworks to use TDD.

## Mockito

Mockito is a framework which can be used to mock the implementation and write test cases around it.

### Test Class:

In order to automatically create the instances of the Mocked Objects it is mandatory to use **@RunWith(MockitoJUnitRunner.class)** at the top of the class as given below.


```
@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    ItemDao daoMock;

    @InjectMocks
    private ItemService service;

```

### Stubbing Method Calls:

#### thenReturn:
This call will return a response based on the mocked object.

The below call will return a new object when the getItem() method is invoked on a mocked object.  

```
when(daoMock.getItem(anyInt())).thenReturn(new Item());
```

#### thenCallRealMethod:
This call will invoke the real method instead of a mocked call.

```
when(daoMock.getItem(anyInt())).thenCallRealMethod();
```
#### thenThrow:

This call will throw the exception when the particular method is invoked.

```
@Test(expected = RuntimeException.class)
    public void getItem_Exception(){

        when(daoMock.getItem(anyInt())).thenThrow(new RuntimeException());
        Optional<Item> item = service.getItem(0);
    }
```

### Verify:
This feature is to verify the operations on the mocked object.

#### times(n):
The below call will verify that the **getItem** method is called exactly once.

```
verify(daoMock,times(1)).getItem(anyInt());
```

#### atLeastOnce:
The below call will verify that the **getItem** method is called atleast once.

```
verify(daoMock,atLeastOnce()).getItem(anyInt());
```

#### atLeast(n)):
The below call will verify that the **getItem** method is called atlease 2 times but can be called more than that.

```
verify(daoMock,atLeast(2)).getItem(anyInt());
```

#### atMost(n)):
The below call will verify that **getItem** method is called atmost 2 times.

```
verify(daoMock,atMost(2)).getItem(anyInt());
```

#### never() - Zero verification :
The below call will verify that **getItem** method is never called on the mock.

```
verify(daoMock,atMost(2)).getItem(anyInt());
```

#### Zero Interactions:
The below call is to make sure that there are zero interactions to the mocked object.

```
verifyZeroInteractions(daoMock);
```

#### Zero Interactions:
The below call is to make sure that there are zero interactions to the mocked object.This method uses varargs to allow us to verify no interactions with several mocks in one line of code.

```
verifyZeroInteractions(daoMock);
```

#### NoMoreInteractions:
The below call will fail because there is an intraction with the mocked object after the verifyNoMoreInteractions call at line number 2.

```
verify(daoMock,atMost(2)).getItem(anyInt());
verifyNoMoreInteractions(daoMock);
Optional<Item> item1 = service.getItem(0);
verifyNoMoreInteractions(daoMock);
assertNotNull(item);
```

### void Method calls:


### Verification Order:

### Capturing Arguments:

Using the input arguments you are constructing an object and the method does not return that object. In that case you need to validate that object , we can use Mocktio argument matchers to handle this scenario.

ArgumentCaptor allows you to capture the actual object passed in to the mock.

Check the below code snippet to fetch the object that was constructed and validated.  

```
when(daoMock.updateItem(anyObject())).thenReturn(true);
       int itemVal = 1;
       boolean result =  service.updateItem(itemVal);

       assertTrue(result);

       ArgumentCaptor<Item> itemCaptor = ArgumentCaptor.forClass(Item.class);

       verify(daoMock).updateItem(itemCaptor.capture());

       Item item = itemCaptor.getValue();

       assertEquals(itemVal,(int) item.getItemId());
```

### Partial Mocking:

- Partial mocking mixes controlled invocation stubs with real method calls.

Things to keep in mind:   
- Cannot mock final methods.
- Cannot mock private methods.
- Set the state appropriately.

When stubbing a spy the initial call is routed to the real method.  

### Power Mock:
