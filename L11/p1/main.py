import asyncio
from queue import Queue

queue = Queue()

async def sum_funct(name, n):
    print(f"Task {name} : Compute sum(0..{n})")
    await asyncio.sleep(2)
    s = sum(range(n+1))
    print(f"Task {name}: sum(0..{n}) = {s}")

async def main():
    # Schedule three calls *concurrently*:
    await asyncio.gather(
        sum_funct("A", queue.get()),
        sum_funct("B", queue.get()),
        sum_funct("C", queue.get()),
        sum_funct("D", queue.get()),
    )


if __name__ == '__main__':
    queue.put(234)
    queue.put(100)
    queue.put(1)
    queue.put(12333)
    asyncio.run(main())